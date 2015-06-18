package org.uqbar.thin.javaless

import org.scalatest.FreeSpec
import org.uqbar.testing.ParserTest

class JavalessParserTest extends FreeSpec with ParserTest[JavalessParserDefinition] with JavalessParserDefinition {

	val terminals = DefaultTerminals

	"Javaless parsing of" - {

		"classes" - {
			implicit val parser = classDefinition

			"should succeed" - {
				"for an empty class" in {
					"class MyClass { }" should beParsedTo(Class("MyClass", Nil))
				}

				"for a class with one field" in {
					"class MyClass { foo }" should beParsedTo(Class("MyClass", List(Field("foo"))))
				}

				"for a class with multiple fields" in {
					"class MyClass { foo bar }" should beParsedTo(Class("MyClass", List(Field("foo"), Field("bar"))))
				}

				"for a class with one method" in {
					"class MyClass { calculate() {} }" should beParsedTo(Class("MyClass", List(Method("calculate", Nil, Nil))))
				}

				"for a class with multiple methods" in {
					"class MyClass { calculate(arg1, arg2) {} recalculate(){ } }" should beParsedTo(Class("MyClass", List(Method("calculate", List("arg1", "arg2"), Nil), Method("recalculate", Nil, Nil))))
				}
			}
		}

		"methods" - {
			implicit val parser = methodDefinition

			"with no arguments" in {
				"calculate(){}" should beParsedTo(Method("calculate", Nil, Nil))
			}

			"with one argument" in {
				"calculate(x){}" should beParsedTo(Method("calculate", "x" :: Nil, Nil))
			}

			"with three arguments" in {
				"calculate(x,y,z){}" should beParsedTo(Method("calculate", "x" :: "y" :: "z" :: Nil, Nil))
			}
			
			"with a body" in ???
		}

		"fields" - {
			implicit val parser = fieldDefinition

			"with a valid name" in {
				"foo" should beParsedTo(Field("foo"))
			}
		}

		"sentences" - {

			"expressions" - {

				"messages" - {
					
					"to a simple receiver ẅith no arguments" in ???
					"to a simple receiver with one simple argument" in ???
					"to a simple receiver with three simple arguments" in ???
					"to a simple receiver with three message chains as arguments" in ???
					"to a message chain result with three message chains as arguments" in ???
				
				}
			}
		}

	}

}