fun main()
{
	println("TEST null index")

	var a:Int = 12

	println(a)

//	a = null	//error

	var b:Int? = 12

	println(b?.times(a))

	if(b != null)		//a != null -> This is always 'true'
		println(a*b)

	b = null

	println(b)
}
