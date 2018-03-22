<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rembo
  Date: 13.03.2018
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Title</title>
    <meta charset="UTF-8">
    <link href="/css/index.css" rel="stylesheet">
</head>
<body>

<div class="save__author">
    <p>Create author</p>
    <input type="text" name="name" id="name" placeholder="name">
    <input type="text" name="gender" id="gender" placeholder="gender">
    <input type="date" name="born" id="born" placeholder="born">
    <button id="saveAuthor">save</button>
</div>

<div class="save__book">
    <p>Create book</p>
    <input type="text" name="name" id="namebook" placeholder="name">
    <input type="date" name="published" id="published" placeholder="published">
    <input type="text" name="genre" id="genre" placeholder="genre">
    <input type="number" name="rating" id="rating" placeholder="rating">
    <select id="list"></select>
    <button id="saveBook">save</button>
</div>

<p>Delete author</p>

<input type="text" name="name" id="deleteAuthorName" placeholder="name">
<button id="deleteAuthor">delete</button>

<p>Delete book</p>
<input type="text" name="name" id="deleteBookName" placeholder="name">
<button id="deleteBook">delete</button>


<div class="but__wrap">
    <div class="but">
        <p>Show all books</p>
        <button id="showBooks">show</button>
    </div>
    <div class="but">
        <p>Show all authors</p>
        <button id="showAuthors">show</button>
    </div>
    <div class="but">
        <p>Show authors which are older 55 years old and sort them by `born` column</p>
        <button id="showOlderThan">show</button>
    </div>
    <div class="but">
        <p>Return books whose author has more than 1 written books</p>
        <button id="booksWhose">show</button>
    </div>
    <div class="but">
        <p>Find out author which has most books</p>
        <button id="getAuthorWhichHasTheMostBook">show</button>
    </div>
    <div class="but">
        <p>Calculate number of books by genre</p>
        <button id="findByGenreCount">show</button>
    </div>

</div>
<hr>

<div class="target"></div>

<script src="../js/index.js"></script>

</body>
</html>
