package ${basePackage}.${model.package};
import java.util.Date;
import java.io.Serializable;

public class ${model.class} implements  Serializable{
	
	<#list model.properties as p>
	private ${p.type} ${p.name};
	</#list>


	<#list model.properties as p>
	public ${p.type} get${p.name?substring(0,1)?upper_case}${p.name?substring(1)}() {
		return ${p.name};
	}

	public void set${p.name?substring(0,1)?upper_case}${p.name?substring(1)}(${p.type} ${p.name}) {
		this.${p.name} = ${p.name};
	}	
	</#list>
	
}
