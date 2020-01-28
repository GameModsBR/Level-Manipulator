package br.com.gamemods.levelmanipulator.catalog

class JavaEditionItem(
    override val id: NamespacedIdentification,
    override val meta: NumericalIdentification?,
    override val block: JavaEditionBlockState?
) : Item<NamespacedIdentification, NumericalIdentification, JavaEditionBlockState>() 
