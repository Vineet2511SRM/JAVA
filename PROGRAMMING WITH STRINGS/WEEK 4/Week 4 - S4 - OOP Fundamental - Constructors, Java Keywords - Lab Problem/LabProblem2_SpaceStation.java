/**
 * Program Name: LabProblem2_SpaceStation.java
 * Author: Vineet Seth
 * Description: Space Station Crew Management System
 * Covers constructor overloading, final keyword usage, 
 * static members, specialized crew types, and emergency handling.
 */

import java.util.*;

// (b) CrewRank enum with final usage
enum CrewRank {
    CADET(1), OFFICER(2), COMMANDER(3), CAPTAIN(4), ADMIRAL(5);

    private final int level;

    CrewRank(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

// (a) SpaceCrew class with strategic final usage
class SpaceCrew {
    private final String crewId;          // permanent unique ID
    private final String homeplanet;      // cannot change
    private final CrewRank initialRank;   // fixed starting rank

    // Regular fields
    private CrewRank currentRank;
    private int skillLevel;
    private int missionCount;
    private int spaceHours;

    // Static members
    static final String STATION_NAME = "Stellar Odyssey";
    static final int MAX_CREW_CAPACITY = 50;

    // (c) Constructors

    // Emergency recruitment (minimal info, random planet)
    public SpaceCrew(CrewRank rank) {
        this("Unknown", getRandomPlanet(), rank, 1, 0, 0);
    }

    // Standard recruitment (name, planet, rank)
    public SpaceCrew(String name, String planet, CrewRank rank) {
        this(name, planet, rank, 1, 0, 0);
    }

    // Experienced transfer (with missions & skill level)
    public SpaceCrew(String name, String planet, CrewRank rank, int skill, int missions) {
        this(name, planet, rank, skill, missions, missions * 100);
    }

    // Full profile constructor
    public SpaceCrew(String name, String planet, CrewRank rank, int skill, int missions, int hours) {
        this.crewId = generateCrewId();
        this.homeplanet = planet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.skillLevel = skill;
        this.missionCount = missions;
        this.spaceHours = hours;
    }

    // Helper: Generate unique ID
    private static String generateCrewId() {
        return "CREW-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }

    // Helper: Random planet
    private static String getRandomPlanet() {
        String[] planets = {"Mars", "Venus", "Titan", "Europa", "Neptune"};
        return planets[new Random().nextInt(planets.length)];
    }

    // (d) Final methods
    public final String getCrewIdentification() {
        return "ID: " + crewId + " | Planet: " + homeplanet + " | Initial Rank: " + initialRank;
    }

    public final boolean canBePromoted() {
        return currentRank != CrewRank.ADMIRAL && skillLevel > 50;
    }

    public final int calculateSpaceExperience() {
        return (missionCount * 100) + (spaceHours / 2) + (skillLevel * 10);
    }

    // Methods for progression
    public void completeMission() {
        missionCount++;
        skillLevel += 2;
        spaceHours += 100;
        if (canBePromoted()) {
            promote();
        }
    }

    private void promote() {
        switch (currentRank) {
            case CADET: currentRank = CrewRank.OFFICER; break;
            case OFFICER: currentRank = CrewRank.COMMANDER; break;
            case COMMANDER: currentRank = CrewRank.CAPTAIN; break;
            case CAPTAIN: currentRank = CrewRank.ADMIRAL; break;
            default: break;
        }
    }

    // Overridden descriptive status
    @Override
    public String toString() {
        return String.format("[SpaceCrew] ID: %s | Planet: %s | Initial Rank: %s | Current Rank: %s | Skill: %d | Missions: %d | Hours: %d",
                crewId, homeplanet, initialRank, currentRank, skillLevel, missionCount, spaceHours);
    }

    public CrewRank getCurrentRank() { return currentRank; }
    public String getCrewId() { return crewId; }
}

// (e) Specialized Crew Types
class PilotCrew extends SpaceCrew {
    private final String flightCertification;

    public PilotCrew(String name, String planet, CrewRank rank, String certification) {
        super(name, planet, rank);
        this.flightCertification = certification; 
    }

    @Override
    public String toString() {
        return String.format("[PilotCrew] %s | Rank: %s | Flight Certification: %s",
                getCrewIdentification(), getCurrentRank(), flightCertification);
    }
}

class ScienceCrew extends SpaceCrew {
    private final String researchField;

    public ScienceCrew(String name, String planet, CrewRank rank, String field) {
        super(name, planet, rank);
        this.researchField = field; 
    }

    @Override
    public String toString() {
        return String.format("[ScienceCrew] %s | Rank: %s | Research Field: %s",
                getCrewIdentification(), getCurrentRank(), researchField);
    }
}

class EngineerCrew extends SpaceCrew {
    private final String engineeringType;

    public EngineerCrew(String name, String planet, CrewRank rank, String type) {
        super(name, planet, rank);
        this.engineeringType = type; 
    }

    @Override
    public String toString() {
        return String.format("[EngineerCrew] %s | Rank: %s | Engineering Type: %s",
                getCrewIdentification(), getCurrentRank(), engineeringType);
    }
}

// (f) Final class SpaceStationRegistry
final class SpaceStationRegistry {
    private static List<SpaceCrew> crewList = new ArrayList<>();

    public static void addCrew(SpaceCrew crew) {
        if (crewList.size() < SpaceCrew.MAX_CREW_CAPACITY) {
            crewList.add(crew);
        }
    }

    public static void showAllCrew() {
        for (SpaceCrew crew : crewList) {
            System.out.println(crew); // uses overridden toString()
        }
    }

    public static int getTotalCrew() {
        return crewList.size();
    }

    // (g) Space Emergency Scenario
    public static void handleEmergency() {
        System.out.println("\n=== Space Emergency Simulation ===");
        boolean hasPilot = false, hasEngineer = false, hasScience = false;

        for (SpaceCrew crew : crewList) {
            if (crew instanceof PilotCrew) hasPilot = true;
            if (crew instanceof EngineerCrew) hasEngineer = true;
            if (crew instanceof ScienceCrew) hasScience = true;
        }

        System.out.println("Crisis detected! Checking for essential crew...");
        if (hasPilot) System.out.println(" Pilot with certification ready");
        if (hasScience) System.out.println(" Science crew with specialization ready");
        if (hasEngineer) System.out.println(" Engineer crew with certification ready");

        if (hasPilot && hasEngineer && hasScience) {
            System.out.println("All critical crew present → Emergency successfully handled!");
        } else {
            System.out.println(" Critical failure! Required crew not available.");
        }
    }
}

// ------------------ Main Class ------------------
public class LabProblem2_SpaceStation {
    public static void main(String[] args) {
        // Recruit crew
        SpaceCrew cadet = new SpaceCrew(CrewRank.CADET);
        SpaceCrew officer = new SpaceCrew("Lara", "Venus", CrewRank.OFFICER);
        SpaceCrew commander = new SpaceCrew("Zane", "Neptune", CrewRank.COMMANDER, 40, 10);
        PilotCrew pilot = new PilotCrew("Aero", "Earth", CrewRank.OFFICER, "Interstellar Pilot");
        ScienceCrew scientist = new ScienceCrew("Iris", "Europa", CrewRank.COMMANDER, "Astrobiology");
        EngineerCrew engineer = new EngineerCrew("Orion", "Titan", CrewRank.CAPTAIN, "Quantum Mechanics");

        // Register crew
        SpaceStationRegistry.addCrew(cadet);
        SpaceStationRegistry.addCrew(officer);
        SpaceStationRegistry.addCrew(commander);
        SpaceStationRegistry.addCrew(pilot);
        SpaceStationRegistry.addCrew(scientist);
        SpaceStationRegistry.addCrew(engineer);

        // Show crew
        System.out.println("\n=== Crew Members at " + SpaceCrew.STATION_NAME + " ===");
        SpaceStationRegistry.showAllCrew();

        // Statistics
        System.out.println("\n=== Crew Statistics ===");
        System.out.println("Total Crew Registered: " + SpaceStationRegistry.getTotalCrew());
        System.out.println("Station Capacity: " + SpaceCrew.MAX_CREW_CAPACITY);
        System.out.println("Station Name: " + SpaceCrew.STATION_NAME);

        // Emergency simulation
        SpaceStationRegistry.handleEmergency();

        // Promotion & Experience check
        System.out.println("\n--- Promotion & Experience Check ---");
        System.out.println("Crew " + officer.getCrewIdentification() + " can be promoted? " + officer.canBePromoted());
        System.out.println("Crew " + officer.getCrewIdentification() + " Space Experience Score: " + officer.calculateSpaceExperience());
        System.out.println("Crew " + cadet.getCrewIdentification() + " can be promoted? " + cadet.canBePromoted());
        System.out.println("Crew " + cadet.getCrewIdentification() + " Space Experience Score: " + cadet.calculateSpaceExperience());
    }
}
