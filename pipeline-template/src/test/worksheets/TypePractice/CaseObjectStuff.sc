

// https://stackoverflow.com/questions/32078526/difference-between-case-class-and-case-object
// https://madusudanan.com/blog/scala-tutorials-part-10-case-objects-in-scala/#Advantages


//Will print false
println(SerializationExample.isInstanceOf[Serializable])
//Will print true
println(CaseObjectSerializationExample.isInstanceOf[Serializable])

object SerializationExample {

}

case object CaseObjectSerializationExample {

}


// case object versus the normal object
// https://www.journaldev.com/12122/scala-caseclass-caseobject-part2


// https://stackoverflow.com/questions/5270752/difference-between-case-object-and-object
// example of the writer