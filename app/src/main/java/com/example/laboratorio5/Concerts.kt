package com.example.laboratorio5

data class Concerts(
    val id: Int,
    val name: String,
    val date: String,
    val location: String,
    val description: String,
    val favorite: Boolean,
    val image: Int
)

fun createConcerts(): List<Concerts> {
    return listOf(
        Concerts(1, "Metallica", "03/11/2014", "Guatemala", "Concierto de Metallica en Guatemala", true, 1),
        Concerts(2, "Eladio Carrion", "03/11/2023", "Guatemala", "Concierto de Eladio Carrion y Young Miko en Guatemala", false, 2),
        Concerts(3, "Cuco", "22/11/2019", "Guatemala", "Concierto de Cuco", true, 3),
        Concerts(4, "Bad Bunny", "10/10/2024", "Ciudad de México", "Concierto de Bad Bunny en Ciudad de México", false, 4),
        Concerts(5, "Dua Lipa", "15/09/2024", "Los Ángeles", "Concierto de Dua Lipa en Los Ángeles", false, 5),
        Concerts(6, "Pink Floyd", "12/08/1970", "Pompeii", "Concierto de Pink Floyd en Pompeii", true, 6),
        Concerts(7, "Coldplay", "25/12/2024", "Barcelona", "Concierto de Coldplay en Barcelona", true, 7),
    )
}



