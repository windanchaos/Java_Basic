#建造者模式

建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。

## 介绍

**意图：**将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。

**主要解决：**主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。

**何时使用：**一些基本部件不会变，而其组合经常变化的时候。

**如何解决：**将变与不变分离开。

**关键代码：**建造者：创建和提供实例，导演：管理建造出来的实例的依赖关系。

**应用实例：**
1、去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。
2、JAVA 中的 StringBuilder。

**优点：**
1、建造者独立，易扩展。
2、便于控制细节风险。

**缺点：**
1、产品必须有共同点，范围有限制。
2、如内部变化复杂，会有很多的建造类。

**使用场景：**
1、需要生成的对象具有复杂的内部结构。
2、需要生成的对象内部属性本身相互依赖。

**注意事项：**与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。

## 实现

我们假设一个快餐店的商业案例，其中，一个典型的套餐可以是一个汉堡（Burger）和一杯冷饮（Cold drink）。汉堡（Burger）可以是素食汉堡（Veg Burger）或鸡肉汉堡（Chicken Burger），它们是包在纸盒中。冷饮（Cold drink）可以是可口可乐（coke）或百事可乐（pepsi），它们是装在瓶子中。

我们将创建一个表示食物条目（比如汉堡和冷饮）的 _Item_ 接口和实现 _Item_ 接口的实体类，以及一个表示食物包装的 _Packing_ 接口和实现 _Packing_ 接口的实体类，汉堡是包在纸盒中，冷饮是装在瓶子中。

然后我们创建一个 _Meal_ 类，带有 _Item_ 的 _ArrayList_ 和一个通过结合 _Item_ 来创建不同类型的 _Meal_ 对象的 _MealBuilder_。_BuilderPatternDemo_，我们的演示类使用 _MealBuilder_ 来创建一个 _Meal_。

![建造者模式的 UML 图](http://www.runoob.com/wp-content/uploads/2014/08/builder_pattern_uml_diagram.jpg)

### 步骤 1

创建一个表示食物条目和食物包装的接口。

_Item.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">interface</span><span class="pln"> </span><span class="typ">Item</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">();</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> packing</span><span class="pun">();</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">();</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;
</span><span class="pun">}</span></pre>

_Packing.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">interface</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> pack</span><span class="pun">();</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 2

创建实现 Packing 接口的实体类。

_Wrapper.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Wrapper</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> pack</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="str">"Wrapper"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_Bottle.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Bottle</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> pack</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="str">"Bottle"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 3

创建实现 Item 接口的抽象类，该类提供了默认的功能。

_Burger.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">abstract</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Burger</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Item</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> packing</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Wrapper</span><span class="pun">();</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">abstract</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">();</span><span class="pln">
</span><span class="pun">}</span></pre>

_ColdDrink.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">abstract</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">ColdDrink</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Item</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="lit">@Override</span><span class="pln">
&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> packing</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
       </span><span class="kwd">return</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Bottle</span><span class="pun">();</span><span class="pln">
&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="pun">}</span><span class="pln">

&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="lit">@Override</span><span class="pln">
&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">abstract</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">();</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 4

创建扩展了 Burger 和 ColdDrink 的实体类。

_VegBurger.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">VegBurger</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">Burger</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="lit">25.0f</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="str">"Veg Burger"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_ChickenBurger.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">ChickenBurger</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">Burger</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="lit">50.5f</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="str">"Chicken Burger"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_Coke.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Coke</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">ColdDrink</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="lit">30.0f</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="str">"Coke"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_Pepsi.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Pepsi</span><span class="pln"> </span><span class="kwd">extends</span><span class="pln"> </span><span class="typ">ColdDrink</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> price</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="lit">35.0f</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> </span><span class="str">"Pepsi"</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 5

创建一个 Meal 类，带有上面定义的 Item 对象。

_Meal.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">ArrayList</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Meal</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Item</span><span class="pun">&gt;</span><span class="pln"> items </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ArrayList</span><span class="pun">&lt;</span><span class="typ">Item</span><span class="pun">&gt;();</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;

   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> addItem</span><span class="pun">(</span><span class="typ">Item</span><span class="pln"> item</span><span class="pun">){</span><span class="pln">
      items</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="pln">item</span><span class="pun">);</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> getCost</span><span class="pun">(){</span><span class="pln">
      </span><span class="kwd">float</span><span class="pln"> cost </span><span class="pun">=</span><span class="pln"> </span><span class="lit">0.0f</span><span class="pun">;</span><span class="pln">
      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Item</span><span class="pln"> item </span><span class="pun">:</span><span class="pln"> items</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         cost </span><span class="pun">+=</span><span class="pln"> item</span><span class="pun">.</span><span class="pln">price</span><span class="pun">();</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </span><span class="kwd">return</span><span class="pln"> cost</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> showItems</span><span class="pun">(){</span><span class="pln">
      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Item</span><span class="pln"> item </span><span class="pun">:</span><span class="pln"> items</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="kwd">print</span><span class="pun">(</span><span class="str">"Item : "</span><span class="pun">+</span><span class="pln">item</span><span class="pun">.</span><span class="pln">name</span><span class="pun">());</span><span class="pln">
         </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="kwd">print</span><span class="pun">(</span><span class="str">", Packing : "</span><span class="pun">+</span><span class="pln">item</span><span class="pun">.</span><span class="pln">packing</span><span class="pun">().</span><span class="pln">pack</span><span class="pun">());</span><span class="pln">
         </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">", Price : "</span><span class="pun">+</span><span class="pln">item</span><span class="pun">.</span><span class="pln">price</span><span class="pun">());</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </span><span class="pun">}</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;
</span><span class="pun">}</span></pre>

### 步骤 6

创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。

_MealBuilder.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">MealBuilder</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Meal</span><span class="pln"> prepareVegMeal </span><span class="pun">(){</span><span class="pln">
      </span><span class="typ">Meal</span><span class="pln"> meal </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Meal</span><span class="pun">();</span><span class="pln">
      meal</span><span class="pun">.</span><span class="pln">addItem</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">VegBurger</span><span class="pun">());</span><span class="pln">
      meal</span><span class="pun">.</span><span class="pln">addItem</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Coke</span><span class="pun">());</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> meal</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">   

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Meal</span><span class="pln"> prepareNonVegMeal </span><span class="pun">(){</span><span class="pln">
      </span><span class="typ">Meal</span><span class="pln"> meal </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Meal</span><span class="pun">();</span><span class="pln">
      meal</span><span class="pun">.</span><span class="pln">addItem</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ChickenBurger</span><span class="pun">());</span><span class="pln">
      meal</span><span class="pun">.</span><span class="pln">addItem</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Pepsi</span><span class="pun">());</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> meal</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 7

BuiderPatternDemo 使用 MealBuider 来演示建造者模式（Builder Pattern）。

_BuilderPatternDemo.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">BuilderPatternDemo</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> main</span><span class="pun">(</span><span class="typ">String</span><span class="pun">[]</span><span class="pln"> args</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">MealBuilder</span><span class="pln"> mealBuilder </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">MealBuilder</span><span class="pun">();</span><span class="pln">

      </span><span class="typ">Meal</span><span class="pln"> vegMeal </span><span class="pun">=</span><span class="pln"> mealBuilder</span><span class="pun">.</span><span class="pln">prepareVegMeal</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Veg Meal"</span><span class="pun">);</span><span class="pln">
      vegMeal</span><span class="pun">.</span><span class="pln">showItems</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Total Cost: "</span><span class="pln"> </span><span class="pun">+</span><span class="pln">vegMeal</span><span class="pun">.</span><span class="pln">getCost</span><span class="pun">());</span><span class="pln">

      </span><span class="typ">Meal</span><span class="pln"> nonVegMeal </span><span class="pun">=</span><span class="pln"> mealBuilder</span><span class="pun">.</span><span class="pln">prepareNonVegMeal</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"\n\nNon-Veg Meal"</span><span class="pun">);</span><span class="pln">
      nonVegMeal</span><span class="pun">.</span><span class="pln">showItems</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Total Cost: "</span><span class="pln"> </span><span class="pun">+</span><span class="pln">nonVegMeal</span><span class="pun">.</span><span class="pln">getCost</span><span class="pun">());</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 8

验证输出。

<pre class="result prettyprint prettyprinted" style=""><span class="typ">Veg</span><span class="pln"> </span><span class="typ">Meal</span><span class="pln">
</span><span class="typ">Item</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Veg</span><span class="pln"> </span><span class="typ">Burger</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Wrapper</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Price</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="lit">25.0</span><span class="pln">
</span><span class="typ">Item</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Coke</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Bottle</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Price</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="lit">30.0</span><span class="pln">
</span><span class="typ">Total</span><span class="pln"> </span><span class="typ">Cost</span><span class="pun">:</span><span class="pln"> </span><span class="lit">55.0</span><span class="pln">

</span><span class="typ">Non</span><span class="pun">-</span><span class="typ">Veg</span><span class="pln"> </span><span class="typ">Meal</span><span class="pln">
</span><span class="typ">Item</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Chicken</span><span class="pln"> </span><span class="typ">Burger</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Wrapper</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Price</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="lit">50.5</span><span class="pln">
</span><span class="typ">Item</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Pepsi</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Packing</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Bottle</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Price</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="lit">35.0</span><span class="pln">
</span><span class="typ">Total</span><span class="pln"> </span><span class="typ">Cost</span><span class="pun">:</span><span class="pln"> </span><span class="lit">85.5</span></pre>            
