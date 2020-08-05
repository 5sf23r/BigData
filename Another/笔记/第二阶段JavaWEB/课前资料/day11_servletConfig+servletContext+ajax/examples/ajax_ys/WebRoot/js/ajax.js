function ajaxFunction(){
	var xmlHttp;
	try{
		//现代浏览器（IE7+、Firefox、Chrome、Safari 和 Opera）都有内建的 XMLHttpRequest 对象
		xmlHttp = new XMLHttpRequest();
	}catch(e){
		try{
			//IE6.0
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				//IE5.0及更早版本
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("...");
				throw e;
			}
		}
				}
				return xmlHttp;
			}
