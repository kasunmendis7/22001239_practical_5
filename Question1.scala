import scala.collection.mutable.ListBuffer

object Question1 {
  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    printProductList(productList)
    getTotalProducts(productList)
  }

  def getProductList(): List[String] = {
    val productList = ListBuffer.empty[String]
    var userInput: String = ""

    while (userInput.toLowerCase != "done") {
      print("Enter product name (type 'done' to finish): ")
      userInput = scala.io.StdIn.readLine()
      if (userInput.toLowerCase != "done") {
        productList += userInput
      }
    }
    productList.toList
  }

  def printProductList(products: List[String]): Unit = {
    println("Product List : ")
    var index =1;
    for(product <- products){
      println(s"$index - $product")
      index += 1;
    }
  }

  def getTotalProducts(products: List[String]): Unit = {
    println(s"There are ${products.size} products in the list")
  }
}

