<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<br/><br/><br/><br/><br/><br/>
내 아이디 <input type="text" name="id" value="${id }" size="7"/> <br/>
친구 아이디 <input type="text" name="friend" value="${friend }" size="7"/>

<input type="submit" value="추가하기"/> 
<input type="button" value="취소" id="cancel"/>

<script>
	$("#cancel").click(function(){
		$(this).close();
	});
</script>
