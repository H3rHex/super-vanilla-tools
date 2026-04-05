# Super Vanilla Tools

Super Vanilla Tools is a lightweight Fabric mod that adds area-based mining tools while keeping a vanilla-friendly experience.

## Overview

This mod adds special pickaxes and shovels that break blocks in a 3x3 area based on the face of the block you mine.  
It is designed to reduce repetitive mining and digging without changing Minecraft's core gameplay style.

## Features

- Adds **Area Pickaxes** and **Area Shovels**.
- Breaks blocks in a **3x3 pattern** depending on mining direction.
- Hold **Shift (crouch)** to mine normally in **1x1** mode.
- Works as a quality-of-life extension of vanilla progression.

## How It Works

When you break a block with an area tool:

- Looking at top/bottom faces breaks a horizontal 3x3.
- Looking at north/south faces breaks a vertical 3x3 (X-Y).
- Looking at east/west faces breaks a vertical 3x3 (Y-Z).

If you crouch, area breaking is disabled and only the targeted block is mined.

## Included Tool Types

Area tool variants are available across the common vanilla material tiers:

- Wood
- Stone
- Iron
- Gold
- Diamond
- Netherite

## Installation

1. Install the correct version of **Fabric Loader** for your Minecraft version.
2. Install **Fabric API**.
3. Place this mod `.jar` in your Minecraft `mods` folder.
4. Launch the game with the Fabric profile.

## Compatibility

- Minecraft: `1.21.11` (based on this project setup)
- Mod loader: Fabric

If you use additional gameplay mods, behavior may vary depending on how they modify block breaking events.

## Development

This project is a Fabric mod built with Gradle.

Typical local workflow:
- Import as a Gradle project.
- Use the provided run configuration/tasks for client testing.
- Build with Gradle to generate release jars.

## Project Goals

- Keep vanilla gameplay feel.
- Improve mining and digging efficiency.
- Stay simple and intuitive for survival play.

## Future Plans

Potential future updates may include:

- More area tool types
- Additional quality-of-life options
- Extra balancing and configuration improvements

## License

See `LICENSE` for licensing details.
