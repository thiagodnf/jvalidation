<img src="https://raw.githubusercontent.com/jvalidation/jvalidation/master/src/main/resources/logo-full.png" width="500px"/>

A simple, fast and light-weight validation tool to express pre- and post-conditions in your code

## Status
[![Build Status](https://travis-ci.org/jvalidation/jvalidation.svg?branch=master)](https://travis-ci.org/jvalidation/jvalidation)
[![codecov](https://codecov.io/gh/jvalidation/jvalidation/branch/master/graph/badge.svg)](https://codecov.io/gh/jvalidation/jvalidation)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)

## How to install

This project uses GitHub as a Maven Repository. Then you have just add the following section to your repositories tag in pom.xml

```xml
<repositories>
    <repository>
        <id>jvalidation-github</id>
        <url>https://github.com/jvalidation/mvn-repo/raw/master/releases</url>
    </repository>
</repositories>
```

Then add a dependency into tag of your pom.xml

```xml
<dependency>
    <groupId>org.jvalidation</groupId>
    <artifactId>jvalidation</artifactId>
    <version>1.0.0</version>
</dependency>
```

## How to use

You have to statically import the library entry point:

```java
import static org.jvalidation.Assertive.*
```
Use assertive preconditions to check for programming errors in calling clients:

```java
require(i).isInteger().greaterThan(2);
```

Use assertive postconditions to check for programming errors in your supplied code:

```java
ensure(i).isString().notNull();
```

## Example

This is a simple example how to use the jvalidation

```java

import static org.jvalidation.Assertive.require

public int myMethod(String s, int j) {
				
    require(s).isString().notNull(2);
    require(j).isInteger().greaterThanOrEqualTo(2);

    // your code here
    
    ensure(s).isString().size(2);
    
    return j;
}
```

## Matcher

This project uses the concept of matchers in which each one is responsible for validating a specific object. Each one has its own validation method. The available matchers (you can click to see the available methods) are shown as follows:

![ObjectMatcher](https://travis-ci.org/jvalidation/jvalidation.svg?branch=master)](https://travis-ci.org/jvalidation/jvalidation)
 - ObjectMatcher
 - IntegerMatcher
 - DoubleMatcher
 - StringMatcher
 
## Contributions

Feel free to fork this project, work on it and then make a pull request.

## Questions or Suggestions

Feel free to create <a href="https://github.com/jvalidation/jvalidation/issues">issues</a> here as you need

## License

MIT License

Copyright (c) 2019 Thiago Ferreira

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
