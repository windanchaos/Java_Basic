

# 原型模式

原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用。

## 介绍

**意图：**用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

**主要解决：**在运行期建立和删除原型。

**何时使用：**
1、当一个系统应该独立于它的产品创建，构成和表示时。
2、当要实例化的类是在运行时刻指定时，例如，通过动态装载。
3、为了避免创建一个与产品类层次平行的工厂类层次时。
4、当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。

**如何解决：**利用已有的一个原型对象，快速地生成和原型对象一样的实例。

**关键代码：**
1、实现克隆操作，在 JAVA 继承 Cloneable，重写 clone()，在 .NET 中可以使用 Object 类的 MemberwiseClone() 方法来实现对象的浅拷贝或通过序列化的方式来实现深拷贝。
2、原型模式同样用于隔离类对象的使用者和具体类型（易变类）之间的耦合关系，它同样要求这些"易变类"拥有稳定的接口。

**应用实例：**
1、细胞分裂。
2、JAVA 中的 Object clone() 方法。

**优点：**
1、性能提高。
2、逃避构造函数的约束。

**缺点：**
1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。
2、必须实现 Cloneable 接口。

**使用场景：**
1、资源优化场景。
2、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。
3、性能和安全要求的场景。
4、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
5、一个对象多个修改者的场景。
6、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
7、在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象，然后由工厂方法提供给调用者。原型模式已经与 Java 融为浑然一体，大家可以随手拿来使用。

**注意事项：**与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的。浅拷贝实现 Cloneable，重写，深拷贝是通过实现 Serializable 读取二进制流。

## 实现

我们将创建一个抽象类 _Shape_ 和扩展了 _Shape_ 类的实体类。下一步是定义类 _ShapeCache_，该类把 shape 对象存储在一个 _Hashtable_ 中，并在请求的时候返回它们的克隆。

_PrototypPatternDemo_，我们的演示类使用 _ShapeCache_ 类来获取 _Shape_ 对象。

![原型模式的 UML 图](http://www.runoob.com/wp-content/uploads/2014/08/prototype_pattern_uml_diagram.jpg)

### 步骤 1 

创建一个实现了 _Clonable_ 接口的抽象类。

_Shape.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">abstract</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Shape</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Cloneable</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> id</span><span class="pun">;</span><span class="pln">
   </span><span class="kwd">protected</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> type</span><span class="pun">;</span><span class="pln">

   </span><span class="kwd">abstract</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> draw</span><span class="pun">();</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> getType</span><span class="pun">(){</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> type</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> getId</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> id</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> setId</span><span class="pun">(</span><span class="typ">String</span><span class="pln"> id</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">id </span><span class="pun">=</span><span class="pln"> id</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Object</span><span class="pln"> clone</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">Object</span><span class="pln"> clone </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">null</span><span class="pun">;</span><span class="pln">
      </span><span class="kwd">try</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         clone </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">super</span><span class="pun">.</span><span class="pln">clone</span><span class="pun">();</span><span class="pln">
      </span><span class="pun">}</span><span class="pln"> </span><span class="kwd">catch</span><span class="pln"> </span><span class="pun">(</span><span class="typ">CloneNotSupportedException</span><span class="pln"> e</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         e</span><span class="pun">.</span><span class="pln">printStackTrace</span><span class="pun">();</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> clone</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 2

创建扩展了上面抽象类的实体类。

_Rectangle.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Rectangle</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">Shape</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Rectangle</span><span class="pun">(){</span><span class="pln">
     type </span><span class="pun">=</span><span class="pln"> </span><span class="str">"Rectangle"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> draw</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Inside Rectangle::draw() method."</span><span class="pun">);</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_Square.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Square</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">Shape</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Square</span><span class="pun">(){</span><span class="pln">
     type </span><span class="pun">=</span><span class="pln"> </span><span class="str">"Square"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> draw</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Inside Square::draw() method."</span><span class="pun">);</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_Circle.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Circle</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">Shape</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Circle</span><span class="pun">(){</span><span class="pln">
     type </span><span class="pun">=</span><span class="pln"> </span><span class="str">"Circle"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> draw</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Inside Circle::draw() method."</span><span class="pun">);</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 3

创建一个类，从数据库获取实体类，并把它们存储在一个 _Hashtable_ 中。

_ShapeCache.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">Hashtable</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">ShapeCache</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
&nbsp;&nbsp;&nbsp;&nbsp;
   </span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="typ">Hashtable</span><span class="pun">&lt;</span><span class="typ">String</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Shape</span><span class="pun">&gt;</span><span class="pln"> shapeMap 
      </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Hashtable</span><span class="pun">&lt;</span><span class="typ">String</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Shape</span><span class="pun">&gt;();</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="typ">Shape</span><span class="pln"> getShape</span><span class="pun">(</span><span class="typ">String</span><span class="pln"> shapeId</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">Shape</span><span class="pln"> cachedShape </span><span class="pun">=</span><span class="pln"> shapeMap</span><span class="pun">.</span><span class="kwd">get</span><span class="pun">(</span><span class="pln">shapeId</span><span class="pun">);</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Shape</span><span class="pun">)</span><span class="pln"> cachedShape</span><span class="pun">.</span><span class="pln">clone</span><span class="pun">();</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="com">// 对每种形状都运行数据库查询，并创建该形状</span><span class="pln">
   </span><span class="com">// shapeMap.put(shapeKey, shape);</span><span class="pln">
   </span><span class="com">// 例如，我们要添加三种形状</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> loadCache</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">Circle</span><span class="pln"> circle </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Circle</span><span class="pun">();</span><span class="pln">
      circle</span><span class="pun">.</span><span class="pln">setId</span><span class="pun">(</span><span class="str">"1"</span><span class="pun">);</span><span class="pln">
      shapeMap</span><span class="pun">.</span><span class="pln">put</span><span class="pun">(</span><span class="pln">circle</span><span class="pun">.</span><span class="pln">getId</span><span class="pun">(),</span><span class="pln">circle</span><span class="pun">);</span><span class="pln">

      </span><span class="typ">Square</span><span class="pln"> square </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Square</span><span class="pun">();</span><span class="pln">
      square</span><span class="pun">.</span><span class="pln">setId</span><span class="pun">(</span><span class="str">"2"</span><span class="pun">);</span><span class="pln">
      shapeMap</span><span class="pun">.</span><span class="pln">put</span><span class="pun">(</span><span class="pln">square</span><span class="pun">.</span><span class="pln">getId</span><span class="pun">(),</span><span class="pln">square</span><span class="pun">);</span><span class="pln">

      </span><span class="typ">Rectangle</span><span class="pln"> rectangle </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Rectangle</span><span class="pun">();</span><span class="pln">
      rectangle</span><span class="pun">.</span><span class="pln">setId</span><span class="pun">(</span><span class="str">"3"</span><span class="pun">);</span><span class="pln">
      shapeMap</span><span class="pun">.</span><span class="pln">put</span><span class="pun">(</span><span class="pln">rectangle</span><span class="pun">.</span><span class="pln">getId</span><span class="pun">(),</span><span class="pln">rectangle</span><span class="pun">);</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 4

_PrototypePatternDemo_ 使用 _ShapeCache_ 类来获取存储在 _Hashtable_ 中的形状的克隆。

_PrototypePatternDemo.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">PrototypePatternDemo</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> main</span><span class="pun">(</span><span class="typ">String</span><span class="pun">[]</span><span class="pln"> args</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">ShapeCache</span><span class="pun">.</span><span class="pln">loadCache</span><span class="pun">();</span><span class="pln">

      </span><span class="typ">Shape</span><span class="pln"> clonedShape </span><span class="pun">=</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Shape</span><span class="pun">)</span><span class="pln"> </span><span class="typ">ShapeCache</span><span class="pun">.</span><span class="pln">getShape</span><span class="pun">(</span><span class="str">"1"</span><span class="pun">);</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Shape : "</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> clonedShape</span><span class="pun">.</span><span class="pln">getType</span><span class="pun">());</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      </span><span class="typ">Shape</span><span class="pln"> clonedShape2 </span><span class="pun">=</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Shape</span><span class="pun">)</span><span class="pln"> </span><span class="typ">ShapeCache</span><span class="pun">.</span><span class="pln">getShape</span><span class="pun">(</span><span class="str">"2"</span><span class="pun">);</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Shape : "</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> clonedShape2</span><span class="pun">.</span><span class="pln">getType</span><span class="pun">());</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      </span><span class="typ">Shape</span><span class="pln"> clonedShape3 </span><span class="pun">=</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Shape</span><span class="pun">)</span><span class="pln"> </span><span class="typ">ShapeCache</span><span class="pun">.</span><span class="pln">getShape</span><span class="pun">(</span><span class="str">"3"</span><span class="pun">);</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Shape : "</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> clonedShape3</span><span class="pun">.</span><span class="pln">getType</span><span class="pun">());</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 5

验证输出。

<pre class="result prettyprint prettyprinted" style=""><span class="typ">Shape</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Circle</span><span class="pln">
</span><span class="typ">Shape</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Square</span><span class="pln">
</span><span class="typ">Shape</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Rectangle</span></pre>    		
