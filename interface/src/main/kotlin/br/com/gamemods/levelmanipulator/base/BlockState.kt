package br.com.gamemods.levelmanipulator.base

abstract class BlockState<IdType: Identification, StateType: Identification> {
    abstract val id: IdType
    abstract val state: StateType
}
