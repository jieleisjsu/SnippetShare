<form action="#" th:action="@{/user/creatsnippet}" th:object="${snippet}" method="post">
	<p>Title: <input type="text" th:field="*{title}" /></p>
    <p>Tag: <input type="text" th:field="*{tags}" /></p>
	<p>Tag: <input type="text" th:field="*{content}" /></p>
	<p>Tag: <input type="text" th:field="*{boardID}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>

