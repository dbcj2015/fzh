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
	
	<select id="findById" parameterType="${model.id.type}" resultType="java.util.LinkedHashMap">
		select * from ${model.tableName} where ${model.id.column} = ${'#{'}value}
	</select>
	
	<select id="findByProperty" parameterType="java.util.Map"   resultType="java.util.LinkedHashMap">
		select * from ${model.tableName} 
	</select>


</mapper>