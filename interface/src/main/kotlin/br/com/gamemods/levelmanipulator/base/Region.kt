package br.com.gamemods.levelmanipulator.base

abstract class Region(override val world: World, val pos: RegionPos): Vector2i by pos, InWorld