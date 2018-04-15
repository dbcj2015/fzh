<#list poems as p >
《${p.title}》
	作者：${p.author}
<#list p.paragraphs as ps>
	${ps}
</#list>
--------------------------------
</#list>