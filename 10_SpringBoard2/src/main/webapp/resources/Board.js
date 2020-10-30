 $(function(){
		getData(1,"","");

});

function bdelete(num){
	if(confirm(num+"번째 게시글을 삭제하시겠습니까?")){
		$.get("bDelete", {"num":num},
			function(resp){			
				if(resp=="success") location.href="/board";
								
			}
		)
	}	
}


function getData(pageNum, field, word){
	$.get("bList", {"pageNum":pageNum, "field":field, "word":word},
		function(resp){
			var countStr = "<div align='center'> 총 게시물 수 : "+resp.count+"</div><br>";
			$("#totalCount").html(countStr);
			var htmlTitle="";
			htmlTitle += 
			// ``이거 쓸 땐, 계속해서 += 안됨. 일반 HTML코드처럼 씀
			`
			<table>
			<thead>
			<th scope='col'>번호</th>			
			<th scope='col'>작성자</th>
			<th scope='col'>제목</th>
			<th scope='col'>내용</th>
			<th scope='col'>작성일</th>
			<th scope='col'>조회수</th>
			<th scope='col'>삭제</th></thead>
			`
			
			$("#resultArea thead").html(htmlTitle); 
			
			var htmlCon="";
			$.each(resp.list, function(key, val){
				htmlCon +=
				`
				<tr>
				  <td>${val.num}</td>
		 		  <td><a href="bView?num=${val.num }">${val.writer}</a></td>
				  <td>${val.title}</td>				 
				  <td>${val.content}</td>
				  <td>${val.regdate}</td>
		 		  <td>${val.hitcount}</td>
				  <td><a href="javascript:bdelete(${val.num})">삭제</a></td>
				</tr>					
				`				
			});
			$("#resultArea tbody").html(htmlCon);
			$("#pageArea").html(resp.pageHtml);
			
		}		
	);
} 