

# 过滤器模式

过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。

## 实现

我们将创建一个 _Person_ 对象、_Criteria_ 接口和实现了该接口的实体类，来过滤 _Person_ 对象的列表。_CriteriaPatternDemo_，我们的演示类使用 _Criteria_ 对象，基于各种标准和它们的结合来过滤 _Person_ 对象的列表。

![过滤器模式的 UML 图](http://www.runoob.com/wp-content/uploads/2014/08/filter_pattern_uml_diagram.jpg)

### 步骤 1

创建一个类，在该类上应用标准。

_Person.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Person</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
&nbsp;&nbsp;&nbsp;&nbsp;
   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">;</span><span class="pln">
   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> gender</span><span class="pun">;</span><span class="pln">
   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> maritalStatus</span><span class="pun">;</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="typ">String</span><span class="pln"> name</span><span class="pun">,</span><span class="typ">String</span><span class="pln"> gender</span><span class="pun">,</span><span class="typ">String</span><span class="pln"> maritalStatus</span><span class="pun">){</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">name </span><span class="pun">=</span><span class="pln"> name</span><span class="pun">;</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">gender </span><span class="pun">=</span><span class="pln"> gender</span><span class="pun">;</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">maritalStatus </span><span class="pun">=</span><span class="pln"> maritalStatus</span><span class="pun">;</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> getName</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> name</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> getGender</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> gender</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> getMaritalStatus</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> maritalStatus</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;
</span><span class="pun">}</span></pre>

### 步骤 2

为标准（Criteria）创建一个接口。

_Criteria.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">interface</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> meetCriteria</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">);</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤 3

创建实现了 _Criteria_ 接口的实体类。

_CriteriaMale.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">ArrayList</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">CriteriaMale</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> meetCriteria</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> malePersons </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ArrayList</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;();</span><span class="pln"> 
      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Person</span><span class="pln"> person </span><span class="pun">:</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         </span><span class="kwd">if</span><span class="pun">(</span><span class="pln">person</span><span class="pun">.</span><span class="pln">getGender</span><span class="pun">().</span><span class="pln">equalsIgnoreCase</span><span class="pun">(</span><span class="str">"MALE"</span><span class="pun">)){</span><span class="pln">
            malePersons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="pln">person</span><span class="pun">);</span><span class="pln">
         </span><span class="pun">}</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> malePersons</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_CriteriaFemale.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">ArrayList</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">CriteriaFemale</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> meetCriteria</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> femalePersons </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ArrayList</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;();</span><span class="pln"> 
      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Person</span><span class="pln"> person </span><span class="pun">:</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         </span><span class="kwd">if</span><span class="pun">(</span><span class="pln">person</span><span class="pun">.</span><span class="pln">getGender</span><span class="pun">().</span><span class="pln">equalsIgnoreCase</span><span class="pun">(</span><span class="str">"FEMALE"</span><span class="pun">)){</span><span class="pln">
            femalePersons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="pln">person</span><span class="pun">);</span><span class="pln">
         </span><span class="pun">}</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> femalePersons</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_CriteriaSingle.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">ArrayList</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">CriteriaSingle</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> meetCriteria</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> singlePersons </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ArrayList</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;();</span><span class="pln"> 
      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Person</span><span class="pln"> person </span><span class="pun">:</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         </span><span class="kwd">if</span><span class="pun">(</span><span class="pln">person</span><span class="pun">.</span><span class="pln">getMaritalStatus</span><span class="pun">().</span><span class="pln">equalsIgnoreCase</span><span class="pun">(</span><span class="str">"SINGLE"</span><span class="pun">)){</span><span class="pln">
            singlePersons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="pln">person</span><span class="pun">);</span><span class="pln">
         </span><span class="pun">}</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">
      </span><span class="kwd">return</span><span class="pln"> singlePersons</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_AndCriteria.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">AndCriteria</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> criteria</span><span class="pun">;</span><span class="pln">
   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> otherCriteria</span><span class="pun">;</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">AndCriteria</span><span class="pun">(</span><span class="typ">Criteria</span><span class="pln"> criteria</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> otherCriteria</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">criteria </span><span class="pun">=</span><span class="pln"> criteria</span><span class="pun">;</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">otherCriteria </span><span class="pun">=</span><span class="pln"> otherCriteria</span><span class="pun">;</span><span class="pln"> 
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> meetCriteria</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> firstCriteriaPersons </span><span class="pun">=</span><span class="pln"> criteria</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">);</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </span><span class="kwd">return</span><span class="pln"> otherCriteria</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">firstCriteriaPersons</span><span class="pun">);</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

_OrCriteria.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">OrCriteria</span><span class="pln"> </span><span class="kwd">implements</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> criteria</span><span class="pun">;</span><span class="pln">
   </span><span class="kwd">private</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> otherCriteria</span><span class="pun">;</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">OrCriteria</span><span class="pun">(</span><span class="typ">Criteria</span><span class="pln"> criteria</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Criteria</span><span class="pln"> otherCriteria</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">criteria </span><span class="pun">=</span><span class="pln"> criteria</span><span class="pun">;</span><span class="pln">
      </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">otherCriteria </span><span class="pun">=</span><span class="pln"> otherCriteria</span><span class="pun">;</span><span class="pln"> 
   </span><span class="pun">}</span><span class="pln">

   </span><span class="lit">@Override</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> meetCriteria</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> firstCriteriaItems </span><span class="pun">=</span><span class="pln"> criteria</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">);</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> otherCriteriaItems </span><span class="pun">=</span><span class="pln"> otherCriteria</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">);</span><span class="pln">

      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Person</span><span class="pln"> person </span><span class="pun">:</span><span class="pln"> otherCriteriaItems</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         </span><span class="kwd">if</span><span class="pun">(!</span><span class="pln">firstCriteriaItems</span><span class="pun">.</span><span class="pln">contains</span><span class="pun">(</span><span class="pln">person</span><span class="pun">)){</span><span class="pln">
&nbsp;&nbsp;&nbsp;&nbsp;        firstCriteriaItems</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="pln">person</span><span class="pun">);</span><span class="pln">
         </span><span class="pun">}</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">&nbsp;&nbsp;&nbsp;&nbsp;
      </span><span class="kwd">return</span><span class="pln"> firstCriteriaItems</span><span class="pun">;</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span></pre>

### 步骤4

使用不同的标准（Criteria）和它们的结合来过滤 _Person_ 对象的列表。

_CriteriaPatternDemo.java_

<pre class="prettyprint prettyprinted" style=""><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">ArrayList</span><span class="pun">;</span><span class="pln"> 
</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">List</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">CriteriaPatternDemo</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> main</span><span class="pun">(</span><span class="typ">String</span><span class="pun">[]</span><span class="pln"> args</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
      </span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ArrayList</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;();</span><span class="pln">

      persons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="str">"Robert"</span><span class="pun">,</span><span class="str">"Male"</span><span class="pun">,</span><span class="pln"> </span><span class="str">"Single"</span><span class="pun">));</span><span class="pln">
      persons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="str">"John"</span><span class="pun">,</span><span class="str">"Male"</span><span class="pun">,</span><span class="pln"> </span><span class="str">"Married"</span><span class="pun">));</span><span class="pln">
      persons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="str">"Laura"</span><span class="pun">,</span><span class="str">"Female"</span><span class="pun">,</span><span class="pln"> </span><span class="str">"Married"</span><span class="pun">));</span><span class="pln">
      persons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="str">"Diana"</span><span class="pun">,</span><span class="str">"Female"</span><span class="pun">,</span><span class="pln"> </span><span class="str">"Single"</span><span class="pun">));</span><span class="pln">
      persons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="str">"Mike"</span><span class="pun">,</span><span class="str">"Male"</span><span class="pun">,</span><span class="pln"> </span><span class="str">"Single"</span><span class="pun">));</span><span class="pln">
      persons</span><span class="pun">.</span><span class="pln">add</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Person</span><span class="pun">(</span><span class="str">"Bobby"</span><span class="pun">,</span><span class="str">"Male"</span><span class="pun">,</span><span class="pln"> </span><span class="str">"Single"</span><span class="pun">));</span><span class="pln">

      </span><span class="typ">Criteria</span><span class="pln"> male </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">CriteriaMale</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">Criteria</span><span class="pln"> female </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">CriteriaFemale</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">Criteria</span><span class="pln"> single </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">CriteriaSingle</span><span class="pun">();</span><span class="pln">
      </span><span class="typ">Criteria</span><span class="pln"> singleMale </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">AndCriteria</span><span class="pun">(</span><span class="pln">single</span><span class="pun">,</span><span class="pln"> male</span><span class="pun">);</span><span class="pln">
      </span><span class="typ">Criteria</span><span class="pln"> singleOrFemale </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">OrCriteria</span><span class="pun">(</span><span class="pln">single</span><span class="pun">,</span><span class="pln"> female</span><span class="pun">);</span><span class="pln">

      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Males: "</span><span class="pun">);</span><span class="pln">
      printPersons</span><span class="pun">(</span><span class="pln">male</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">));</span><span class="pln">

      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"\nFemales: "</span><span class="pun">);</span><span class="pln">
      printPersons</span><span class="pun">(</span><span class="pln">female</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">));</span><span class="pln">

      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"\nSingle Males: "</span><span class="pun">);</span><span class="pln">
      printPersons</span><span class="pun">(</span><span class="pln">singleMale</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">));</span><span class="pln">

      </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"\nSingle Or Females: "</span><span class="pun">);</span><span class="pln">
      printPersons</span><span class="pun">(</span><span class="pln">singleOrFemale</span><span class="pun">.</span><span class="pln">meetCriteria</span><span class="pun">(</span><span class="pln">persons</span><span class="pun">));</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">

   </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> printPersons</span><span class="pun">(</span><span class="typ">List</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> persons</span><span class="pun">){</span><span class="pln">
      </span><span class="kwd">for</span><span class="pln"> </span><span class="pun">(</span><span class="typ">Person</span><span class="pln"> person </span><span class="pun">:</span><span class="pln"> persons</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
         </span><span class="typ">System</span><span class="pun">.</span><span class="kwd">out</span><span class="pun">.</span><span class="pln">println</span><span class="pun">(</span><span class="str">"Person : [ Name : "</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> person</span><span class="pun">.</span><span class="pln">getName</span><span class="pun">()</span><span class="pln"> 
            </span><span class="pun">+</span><span class="str">", Gender : "</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> person</span><span class="pun">.</span><span class="pln">getGender</span><span class="pun">()</span><span class="pln"> 
            </span><span class="pun">+</span><span class="str">", Marital Status : "</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> person</span><span class="pun">.</span><span class="pln">getMaritalStatus</span><span class="pun">()</span><span class="pln">
            </span><span class="pun">+</span><span class="str">" ]"</span><span class="pun">);</span><span class="pln">
      </span><span class="pun">}</span><span class="pln">
   </span><span class="pun">}</span><span class="pln">      
</span><span class="pun">}</span></pre>

### 步骤 5

验证输出。

<pre class="result prettyprint prettyprinted" style=""><span class="typ">Males</span><span class="pun">:</span><span class="pln"> 
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Robert</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">John</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Married</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Mike</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Bobby</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">

</span><span class="typ">Females</span><span class="pun">:</span><span class="pln"> 
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Laura</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Female</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Married</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Diana</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Female</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">

</span><span class="typ">Single</span><span class="pln"> </span><span class="typ">Males</span><span class="pun">:</span><span class="pln"> 
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Robert</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Mike</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Bobby</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">

</span><span class="typ">Single</span><span class="pln"> </span><span class="typ">Or</span><span class="pln"> </span><span class="typ">Females</span><span class="pun">:</span><span class="pln"> 
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Robert</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Diana</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Female</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Mike</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Bobby</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Male</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Single</span><span class="pln"> </span><span class="pun">]</span><span class="pln">
</span><span class="typ">Person</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="pun">[</span><span class="pln"> </span><span class="typ">Name</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Laura</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Gender</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Female</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Marital</span><span class="pln"> </span><span class="typ">Status</span><span class="pln"> </span><span class="pun">:</span><span class="pln"> </span><span class="typ">Married</span><span class="pln"> </span><span class="pun">]</span></pre>			

			</div>
