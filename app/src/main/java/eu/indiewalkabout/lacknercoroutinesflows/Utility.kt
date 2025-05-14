package eu.indiewalkabout.lacknercoroutinesflows



// ---------------------------------------------------------------------- lambda samples
// --> this fun get a prefix param, and return a function which accept a message param and return void
fun makePrinter(prefix: String): (String) -> Unit {
    return { message -> println("$prefix: $message") }
}


fun useMakePrinter(prefix: String, message: String){
    val infoPrinter = makePrinter(prefix)
    infoPrinter(message)
}

// -->  this fun get a prefix param, and return a function which accept a message param  and return string
fun makePrinter_02(prefix: String): (String) -> String {
    return { message ->
        println("$prefix: $message");
        prefix + ":"+ message.toString()
    }
}

fun useMakePrinter_02(prefix: String, message: String): String{
    val infoPrinter = makePrinter_02(prefix)
    return infoPrinter(message)
}


// ---> using map
fun useMap(list: List<Int>, operation: (Int) -> Int): List<Int> {
    val result = list.map{ operation(it) }
    return result
}

// using reduce
fun useReduce(list: List<Int>, operation: (Int, Int) -> Int): Int {
    val result = list.reduce{ acc, it -> operation(acc,it) }
    return result
}

// using map and reduce
fun useMapReduce(list: List<Int>, operationMap: (Int) -> Int, operationReduce: (Int, Int) -> Int): Int {
    val result = list.map{operationMap(it)}.reduce{ acc, it -> operationReduce(acc,it) }
    return result
}

// using fold ( takes an initial value)
fun useFold(list: List<Int>, initialValue: Int, operation: (Int, Int) -> Int): Int {
    val result = list.fold(initialValue){ acc, it -> operation(acc,it) }
    return result
}



val list = listOf(1, 2, 3)
val sum = list.map { it * 2 }.reduce { acc, i -> acc + i }




