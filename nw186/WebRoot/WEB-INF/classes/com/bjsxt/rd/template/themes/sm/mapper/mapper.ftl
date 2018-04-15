<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackage}.${repository.package}.${repository.class}">

	<insert id="insert" parameterType="${basePackage}.${model.package}.${model.class}">
		INSERT INTO ${model.tableName} (<#list model.properties as p><#if model.id.column != p.column>${p.column}<#if p_has_next>,</#if></#if></#list>)
		VALUES (<#list model.properties as p><#if model.id.column != p.column>${'#{'}${p.name}}<#if p_has_next>,</#if></#if></#list>)
	</insert>
	
	<update id="update" parameterType="${basePackage}.${model.package}.${model.class}">
		UPDATE ${model.tableName}
			SET  
				<#list model.properties as p>
				<#if p_index !=0  >,</#if>${p.column} = ${'#{'}${p.name}}
				</#list>
			WHERE ${model.id.column} = ${'#{'}${model.id.name}}
			
	</update>
	
	<delete id="delete" parameterType="${model.id.type}">
		DELETE FROM ${model.tableName} where ${model.id.column} = ${'#{'}value}
	</delete>
	
	<select id="findById" parameterType="${model.id.type}" resultType="${basePackage}.${model.package}.${model.class}">
		select
			<#list model.properties as p>
				t.${p.column} ${p.name} <#if p_has_next>,</#if>
			</#list>
		from ${model.tableName} t where t.${model.id.column} = ${'#{'}value}
	</select>
	
	<select id="findByProperty" parameterType="java.util.Map"   resultType="java.util.LinkedHashMap">
		select 
			<#list model.properties as p>
				t.${p.column} ${p.name} <#if p_has_next>,</#if>
			</#list>
		 from ${model.tableName} t where 1=1 
		<#list model.properties as p>
		<if test="${p.name} != null">
		and t.${p.column} =${'#{'}${p.name}}
		</if>
		</#list>
		<if test="st != null and r != null">
			limit ${'#{'}st} , ${'#{'}r}
		</if>
	</select>

	<select id="countByProperty" parameterType="java.util.Map"   resultType="Long">
		select count(*) cnt from ${model.tableName} t where 1=1 
		<#list model.properties as p>
		<if test="${p.name} != null">
		and t.${p.column} =${'#{'}${p.name}}
		</if>
		</#list>
	</select>

</mapper>