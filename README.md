# Orbital Launch System

## Overview

**Orbital Launch System** is a console-based Java application that simulates orbital launch missions and calculates rocket performance metrics. The system allows users to configure mission parameters (target orbit, payload mass, fuel mass) and determines whether a rocket configuration can successfully reach the specified orbital destination based on delta-V calculations.

The application implements the **Model-View-Controller (MVC)** architectural pattern, providing a clean separation of concerns between business logic, data modeling, and user interface components.

## Architecture

The application follows a **Layered Architecture (MVC Pattern)**:

- **Model Layer** (`model/`): Contains the core business logic and data structures (`RocketData`)
- **Controller Layer** (`controller/`): Orchestrates the application flow and coordinates between model and view (`LaunchDirector`)
- **View Layer** (`view/`): Handles user interaction and console output (`MissionControlConsole`)

### Core Components

- **RocketData**: Encapsulates rocket physics calculations including delta-V computation using the Tsiolkovsky rocket equation
- **LaunchDirector**: Controls the launch sequence workflow and mission selection logic
- **MissionControlConsole**: Provides interactive console interface for user input and result display

## Technology Stack

### Core
- **Java**: 21 (LTS)
- **Build System**: IntelliJ IDEA Module (Standard Java Project)

### Testing
- **JUnit 5** (Jupiter): Unit testing framework
- **Assertions**: JUnit 5 assertion API

### Development Tools
- **IDE**: IntelliJ IDEA compatible
- **Java Compiler**: Standard javac (JDK 21)

## Project Structure

```
OrbitalLaunchSystem/
├── src/
│   ├── Main.java                    # Application entry point
│   ├── controller/
│   │   └── LaunchDirector.java      # Controller orchestrating launch sequence
│   ├── model/
│   │   └── RocketData.java          # Rocket physics model and calculations
│   └── view/
│       └── MissionControlConsole.java # Console UI and user interaction
├── test/
│   └── model/
│       └── RocketDataTest.java      # Unit tests for RocketData
└── README.md
```

## Features

- **Mission Target Selection**: Choose from 4 predefined orbital destinations:
  - Low Earth Orbit (LEO) - 7,800 m/s
  - Geostationary Transfer Orbit (GTO) - 10,200 m/s
  - Moon Transfer (TLI) - 11,200 m/s
  - Mars Transfer (TMI) - 11,500 m/s

- **Delta-V Calculation**: Implements the Tsiolkovsky rocket equation:
  ```
  Δv = Isp × g₀ × ln(m₀/mf)
  ```
  Where:
  - `Isp` = Specific impulse (3,070 m/s)
  - `m₀` = Initial mass (structural + payload + fuel)
  - `mf` = Final mass (structural + payload)

- **Mission Success Validation**: Determines if the calculated delta-V meets the required velocity for the selected mission target

- **Input Validation**: Validates user inputs (payload mass, fuel mass) to prevent negative values


## Configuration

This application requires no external configuration files or environment variables. All rocket parameters are hardcoded constants in the `RocketData` class:

| Parameter | Value | Description |
|-----------|-------|-------------|
| `STRUCTURAL_MASS` | 1000 kg | Base structural mass of the rocket |
| `ENGINE_EFFICIENCY` | 3070.0 m/s | Specific impulse (Isp) of the rocket engine |

To modify these values, edit the constants in `src/model/RocketData.java`:

```java
public static final int STRUCTURAL_MASS = 1000;
public static final double ENGINE_EFFICIENCY = 3070.0;
```


### Execution Flow

1. The application displays a welcome message
2. User selects a mission target (1-4)
3. User enters payload mass (kg)
4. User enters fuel mass (kg)
5. System calculates delta-V and validates mission success
6. Results are displayed in the console

### Example Session

```
===   ORBITAL LAUNCH CONTROL SYSTEM    ===
System initialized. Waiting for flight parameters...

Select Mission Target:
1. Low Earth Orbit (LEO)  [7800 m/s]
2. Geostationary (GTO)    [10200 m/s]
3. Moon Transfer (TLI)    [11200 m/s]
4. Mars Transfer (TMI)    [11500 m/s]
>> Enter choice [1-4]: 1
Enter Payload Mass (kg): 100
Enter Fuel Mass (kg): 15000

----------- REPORT -----------
Target Mission: Low Earth Orbit (LEO)
Vehicle Delta-V: 7892.45 m/s
STATUS: [SUCCESS] - TARGET REACHED
Message: Orbit insertion complete. Welcome to Low Earth Orbit (LEO)!
----------------------------------------
```

## Testing

### Educational Focus

**The primary educational goal of this project was to learn and implement unit testing practices.** The test suite demonstrates fundamental testing concepts including test case design, assertion usage, and validation of business logic correctness.


### Test Coverage

The test suite includes:

- **`testSuccessfulLaunch()`**: Validates that a rocket with sufficient fuel can reach LEO
- **`testLaunchFailure()`**: Validates that a rocket with insufficient fuel correctly fails the mission

## Data Model

### RocketData Entity

The `RocketData` class represents the core rocket physics model:

| Field | Type | Description |
|-------|------|-------------|
| `payloadMass` | `double` | Mass of payload in kilograms |
| `fuelMass` | `double` | Mass of propellant in kilograms |
| `STRUCTURAL_MASS` | `int` (constant) | Base structural mass (1000 kg) |
| `ENGINE_EFFICIENCY` | `double` (constant) | Specific impulse (3070 m/s) |

### Methods

- **`calculateDeltaV()`**: Computes the delta-V using Tsiolkovsky equation
- **`canReachOrbit(double requiredSpeed)`**: Determines if delta-V meets mission requirements
- **Constructor**: Validates input parameters (throws `IllegalArgumentException` for negative values)

## Physics Model

The application uses the **Tsiolkovsky Rocket Equation** to calculate delta-V:

```
Δv = Isp × ln(m₀/mf)
```

Where:
- **Δv** (delta-V): Change in velocity required for the mission
- **Isp**: Specific impulse (engine efficiency) = 3070 m/s
- **m₀**: Initial total mass = structural + payload + fuel
- **mf**: Final mass (dry mass) = structural + payload

The system compares the calculated delta-V against mission-specific velocity requirements to determine mission success.

## Error Handling

The application includes input validation:

- **Negative Payload Mass**: Throws `IllegalArgumentException` with message: "The payload mass cannot be negative!"
- **Negative Fuel Mass**: Throws `IllegalArgumentException` with message: "The fuel mass cannot be negative!"
- **Invalid Mission Selection**: Defaults to Low Earth Orbit (LEO) with a warning message


## Author

Developed as an educational project with the **primary learning objective of mastering unit testing practices** using JUnit 5. The project demonstrates:

- **Unit testing fundamentals**: Writing, structuring, and executing test cases
- **Test-driven development concepts**: Validating business logic through automated tests
- Object-oriented design principles
- MVC architectural pattern
- Rocket physics calculations
- Java console application development


