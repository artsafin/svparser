package com.artsafin.shared.dto

object TestData {
    val singleItem = """
{
    "_id" : 12909,
    "id" : 12909,
    "commonName" : "Шерлок",
    "name" : "Сериал Шерлок/Sherlock 4 сезон",
    "url" : "/serial-12909-SHerlok-4-sezon.html",
    "description" : "Девятнадцатый век. Лондон. Канун Рождества. К великому сыщику",
    "genres" : [
        "детективы",
        "триллеры"
    ],
    "year" : "2016",
    "img" : "http://cdn.seasonvar.ru/oblojka/12909.jpg",
    "originalName" : "Sherlock",
    "numSeasons" : 4
}
"""
    val singleItemNullLinkInfo = """
{
    "_id" : 12909,
    "id" : 12909,
    "name" : null,
    "url" : null
}
"""
    val singleItemNullNumSeasons = """
{
    "_id" : 12909,
    "id" : 12909,
    "commonName" : "Шерлок",
    "name" : "Сериал Шерлок/Sherlock 4 сезон",
    "url" : "/serial-12909-SHerlok-4-sezon.html",
    "description" : "Девятнадцатый век. Лондон. Канун Рождества. К великому сыщику",
    "genres" : [
        "детективы",
        "триллеры"
    ],
    "year" : "2016",
    "img" : "http://cdn.seasonvar.ru/oblojka/12909.jpg",
    "originalName" : "Sherlock",
    "numSeasons" : null
}
"""
    val singleItemEmptyGenres = """
{
    "genres" : []
}
"""
    val singleItemNullGenres = """
{
    "genres" : null
}
"""

}