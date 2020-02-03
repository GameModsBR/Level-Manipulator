package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping

import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special.*

internal fun UniversalBlockMapper.listSpecialMappers() = listOf(
    Buttons, WallSigns, BambooSapling, Beehives, FacingDirectionStartingOn2, DeprecatedFixer, AgeProperty, Lever
)
