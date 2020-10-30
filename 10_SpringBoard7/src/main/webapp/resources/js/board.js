$(function(){
	//추가하기
	$("#submit").on("click", function(){
		var writer=$("#writer").val();
		var title=$("#title").val();
		var content=$("#content").val();
		var password=$("#password").val();
		var postString="writer="+writer+"&title="+title+"&content="+content+"&password="+password;
		
		$.ajax({
			type: "post",
			url: "boardInsert",
			data: postString,
			success: function(resp){
				$("#writer").val("");
				$("#title").val("");
				$("#content").val("");
				$("#password").val("");
				location.href="list";
			},
			error: function(e){
				alert("error:"+e)
			}
		})//ajax
	})//submit
});