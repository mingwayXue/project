<html>
<body>
    <h2>Hello World!</h2>
    <h3>springMVC文件上传测试</h3>
    <form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="upload_file" />
        <input type="submit" value="spingmvc文件上传"/>
    </form>

    <h3>富文本文件上传</h3>
    <form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="upload_file" />
        <input type="submit" value="富文本文件上传"/>
    </form>
</body>
</html>
