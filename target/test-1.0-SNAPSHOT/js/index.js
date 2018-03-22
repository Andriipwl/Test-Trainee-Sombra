$(document).ready(function () {
    var out = '';
    $.ajax({
        url: '/allAuthors',
        type: 'GET',
        success: function (data) {
            for (var obj of data) {
                out += '<option value="' + obj.name + '">' + obj.name + '</option>';
                console.log(out);
            }
            $('#list').html(out);
        }
    });
});


$('#saveBook').click(function () {
    var name = $('#namebook').val();
    var published = $('#published').val();
    var genre = $('#genre').val();
    var rating = $('#rating').val();
    var nameAuthor = $('#list').val();

    var authors = {
        nameAuthor
    };

    console.log(nameAuthor);
    var books = {
        "name": name,
        "published": published,
        "genre": genre,
        "rating": rating,
        "authors": authors


    };

    $('.targetcus').empty();
    $.ajax({
        url: '/saveBook',
        type: 'POST',
        data: JSON.stringify(books),
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
        },
        error: function () {
            console.log("errooorrSAVE")
        }

    })

});


$('#saveAuthor').click(function () {
    var name = $('#name').val();
    var gender = $('#gender').val();
    var born = $('#born').val();


    var author = {
        name,
        gender,
        born
    };

    $('.targetcus').empty();
    $.ajax({
        url: '/saveAuthor',
        type: 'POST',
        data: JSON.stringify(author),
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
        },
        error: function () {
            console.log("errooorrSAVE")
        }

    })

});


$('#showAuthors ').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/showAuthors',
        type: 'GET',
        success: function (data) {
            for (let obj of data) {
                let $p = $("<p>", {
                    text: obj.name + " " + obj.gender + " " + obj.born
                });
                $('.target').append($p);
            }
        },
        error: function () {
            console.log("error")
        }
    })
});


$('#showOlderThan ').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/showOlderThan',
        type: 'GET',
        success: function (data) {
            for (let obj of data) {
                let $p = $("<p>", {
                    text: obj.name + " " + obj.gender + " " + obj.born
                });
                $('.target').append($p);
            }
        },
        error: function () {
            console.log("error")
        }
    })
});


$('#getAuthorWhichHasTheMostBook').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/getAuthorWhichHasTheMostBook',
        type: 'GET',
        success: function (data) {
            let $p = $("<p>", {
                text: data
            });
            $('.target').append($p);


        },
        error: function () {
            console.log("error")
        }
    })
});


$('#showBooks ').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/showBooks',
        type: 'GET',
        success: function (data) {
            for (let obj of data) {
                let $p = $("<p>", {
                    text: obj.name + " " + obj.published + " " + obj.genre + " " + obj.rating
                });
                $('.target').append($p);
            }
        },
        error: function () {
            console.log("error")
        }
    })
});


$('#findBookWithAuthor').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/findBookWithAuthor',
        type: 'GET',
        success: function (data) {
            for (let obj of data) {
                let $p = $("<p>", {
                    text: obj.name + " " + obj.published + " " + obj.genre + " " + obj.rating
                });
                $('.target').append($p);
            }
        },
        error: function () {
            console.log("error")
        }
    })
});

$('#findByGenreCount').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/findByGenreCount',
        type: 'GET',
        success: function (data) {
            for (let obj of data) {
                let $p = $("<p>", {
                    text: obj
                });
                $('.target').append($p);
            }
        },
        error: function () {
            console.log("error")
        }
    })
});


$('#booksWhose').click(function () {
    $('.target').empty();
    $.ajax({
        url: '/booksWhoseAuthorHasMoreThanOneWrittenBooks',
        type: 'GET',
        success: function (data) {
            for (let obj of data) {
                let $p = $("<p>", {
                    text: obj
                });
                $('.target').append($p);
            }
        },
        error: function () {
            console.log("error")
        }
    })
});


$('#deleteAuthor').click(function () {
    var name = $('#deleteAuthorName').val();
    var authors = {
        name
    };

    $('.targetcus').empty();
    $.ajax({
        url: '/deleteByName',
        type: 'POST',
        data: JSON.stringify(authors),
        contentType: 'application/json',
        success: function () {
            console.log("deleted");
        },
        error: function () {
            console.log("errooorr")
        }

    })

});


$('#deleteBook').click(function () {
    var name = $('#deleteBookName').val();
    var books = {
        name
    };

    $('.targetcus').empty();
    $.ajax({
        url: '/deleteBookByName',
        type: 'POST',
        data: JSON.stringify(books),
        contentType: 'application/json',
        success: function () {
            console.log("deleted");
        },
        error: function () {
            console.log("errooorr")
        }
    })
});
