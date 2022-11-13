<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/post.css">

    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#img").on('change', function(){
                readURL(this);
            });
        });

        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#upload_img').attr('src', e.target.result);
                }

              reader.readAsDataURL(input.files[0]);
            }
        }


    </script>

</head>

<body>
<div>
<jsp:include page="inc/search.jsp"/>
<jsp:include page="inc/userProfile.jsp"/>	
<jsp:include page="inc/loginCheck.jsp"/>	
</div>

<form action="uploadPost" method="post" enctype="multipart/form-data">
	<div class="post">
		<table class="postTable">
			<tbody>
				<tr><td colspan="2" class="postTop"><a href="mainPage"style="color: white;">뒤로가기</a></td></tr>
				
				<tr><td class="postImg"><img id="upload_img" src="#" alt="image" />
					<input type='file' accept="image/jpeg" id="img" name="f" multiple>
				</td>
				 
				<td class="postContent" >
					<font style="color:white"><%= session.getAttribute("memberId")%></font>
					<hr>
					<div class="textArea">
						<textarea cols="40" rows="20" name="contents">
						 내용을 입력해주세요.
						</textarea>
					</div>
						
				</td>
				</tr>	
				<tr><td colspan="2"><input type="submit" id="submit" value="등록">  </td></tr>	

			</tbody>
		</table>	
		</div>
</form>
</body>
</html>