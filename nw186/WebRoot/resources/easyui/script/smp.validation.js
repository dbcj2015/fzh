/*
		$.extend($.fn.validatebox.defaults.rules, { //这是写死的   
		    ...: {//验证规则名称
		        validator: function(value,param){ //这也是写死的   
		              ...//验证规则，对输入的数据继续验证，验证通过返回true验证失败返回false  
		        },    
		        message: '...' //验证失败的时候显示的文本  
		    }    
		});*/  
	
		$.extend($.fn.validatebox.defaults.rules, { //这是写死的   
		    validName: {//验证规则名称
		        validator: function(value,param){ //这也是写死的   
		        		//在javascript用 利用/正则表达式/创建一个正则对象
		        		var regex = /(^[\u4e00-\u9fa5]{2,10}$)|(^[A-Z][a-z]{0,} [A-Z][a-z]{0,}$)/;
		        		var result = regex.test(value);//将输入的内容与正则进行匹配，匹配成功返回true 否则返回false
		        		//验证规则，对输入的数据继续验证，验证通过返回true验证失败返回false  
		        		return result;
		        },    
		        message: "请输入正确的姓名" //验证失败的时候显示的文本  
		    }    
		});
		$.extend($.fn.validatebox.defaults.rules, { //这是写死的   
		    validMobile: {//验证规则名称
		        validator: function(value,param){ //这也是写死的   
		        	var regex = /^1(33|34|78|31|88|89|32|35|30|59|87|39)\d{8}$/;
	        		var result = regex.test(value);//将输入的内容与正则进行匹配，匹配成功返回true 否则返回false
	        		//验证规则，对输入的数据继续验证，验证通过返回true验证失败返回false  
	        		return result;
		        },    
		        message: "请输入正确的11位手机号码" //验证失败的时候显示的文本  
		    }    
		});
		
		$.extend($.fn.validatebox.defaults.rules, { //这是写死的   
		    validDefaultOption: {//验证规则名称
		        validator: function(value,param){ //这也是写死的   
		        	if(value == "请选择"){
		        		return false;
		        	}else{
		        		return true;
		        	}
		        },    
		        message: "请选择有效的选项" //验证失败的时候显示的文本  
		    }    
		});