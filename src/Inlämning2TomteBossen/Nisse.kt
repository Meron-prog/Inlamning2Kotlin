package Inlämning2TomteBossen


class Nisse(var name:String, var chef: Nisse?) {
    private var under = mutableListOf<Nisse>()

    fun addUnder(nisse: Nisse) {
        under.add(nisse)
    }

    fun getUnderList(): List<Nisse> {
        return under;
    }
}

fun main() {
    val tomten = Nisse("Tomten",null)
    val glader = Nisse("Glader", tomten)
    tomten.addUnder(glader)
    val butter = Nisse("Butter", tomten)
    tomten.addUnder(butter)
    val tröger=Nisse("Tröger",glader)
    glader.addUnder(tröger)
    val trötter=Nisse("Trötter",glader)
    glader.addUnder(trötter)
    val blyger=Nisse("Blyger",glader)
    glader.addUnder(blyger)
    val skumtomten=Nisse("Skumtomten",trötter)
    trötter.addUnder(skumtomten)
    val dammråttan=Nisse("Dammråttan",skumtomten)
    skumtomten.addUnder(dammråttan)
    val rådjuret = Nisse("Rådjuret", butter)
    butter.addUnder(rådjuret)
    val nyckelpigan = Nisse("Nyckelpigan", butter)
    butter.addUnder(nyckelpigan)
    val haren = Nisse("Haren", butter)
    butter.addUnder(haren)
    val räven = Nisse("Räven", butter)
    butter.addUnder(räven)
    val gråsuggan = Nisse("Gråsuggan", räven)
    räven.addUnder(gråsuggan)
    val myran = Nisse("Myran", räven)
    räven.addUnder(myran)
    val bladlusen = Nisse("Bladlusen", myran)
    myran.addUnder(bladlusen)

    fun sendNissechef(nisse: Nisse): String {
        if (nisse.chef == null)
            return ""
        var enSträng = sendNissechef(nisse.chef!!)
        return enSträng + " " + nisse.chef!!.name
    }

    println(sendNissechef(bladlusen))
    println(sendNissechef(dammråttan))
    println(sendNissechef(rådjuret))

    fun sendunderNissechef(nisse:Nisse):String {
        val underNisse= nisse.getUnderList()
        if (underNisse.isEmpty())
            return ""
        var cheferString = ""
        for (item in underNisse)
            cheferString += item.name + " " + sendunderNissechef(item)
        return cheferString;
    }

    println(sendunderNissechef(butter))
    println(sendunderNissechef(tomten))
    println(sendunderNissechef(trötter))

}

