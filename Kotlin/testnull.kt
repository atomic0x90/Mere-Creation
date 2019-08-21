fun main()
{
	println("TEST null index")

	var a:Int = 12

	println(a)

//	a = null	//error

	var b:Int? = 12

	println(b?.times(a))

	b = null

	println(b)
}
