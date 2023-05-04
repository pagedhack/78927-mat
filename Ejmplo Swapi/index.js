//personas
let pe = 0;
var bNext = document.getElementById("nextPer")
bNext.addEventListener("click", function () {
    if (pe === 9) return;
    pe++;
    const index = document.getElementById('indice');
    index.textContent = pe;
    var desper = document.getElementById('desper');
    var film = document.getElementById('film');
    var specie = document.getElementById('specie')
    var ship = document.getElementById('ship');
    var vehi = document.getElementById('vehi');
    desper.innerHTML = '';
    film.innerHTML = '';
    specie.innerHTML = '';
    ship.innerHTML = '';
    vehi.innerHTML = '';
    axios.get("https://swapi.dev/api/people/?page=" + pe)
        .then(function (response) {
            var personas = response.data.results;
            var perh = document.getElementById('lista');
            perh.innerHTML = '';
            var desPer = document.getElementById('desper');
            perh.innerHTML = '';
            // let params = new URLSearchParams(location.search);
            // var contract = params.get('people');
            // console.log(params);
            personas.forEach(function (person) {
                var personadiv = document.createElement('li');
                personadiv.innerHTML = person.name + "<br>" + person.url;
                perh.appendChild(personadiv);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})

var bPeople = document.getElementById("people")
bPeople.addEventListener("click", function () {
    axios.get("https://swapi.dev/api/people")
        .then(function (response) {
            var personas = response.data.results;
            var perh = document.getElementById('lista');
            perh.innerHTML = '';
            personas.forEach(function (person) {
                var personadiv = document.createElement('li');
                personadiv.innerHTML = person.name + "<br>" + person.url;
                perh.appendChild(personadiv);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})

var bPrevious = document.getElementById("previousPer")
bPrevious.addEventListener("click", function () {
    if (pe === 1) return;
    pe--;
    const index = document.getElementById('indice');
    index.textContent = pe;
    axios.get("https://swapi.dev/api/people/?page=" + pe)
        .then(function (response) {
            var personas = response.data.results;
            var perh = document.getElementById('lista');
            perh.innerHTML = '';
            var desper = document.getElementById('desper');
            var film = document.getElementById('film');
            var specie = document.getElementById('specie')
            var ship = document.getElementById('ship');
            var vehi = document.getElementById('vehi');
            desper.innerHTML = '';
            film.innerHTML = '';
            specie.innerHTML = '';
            ship.innerHTML = '';
            vehi.innerHTML = '';
            personas.forEach(function (person) {
                var personadiv = document.createElement('li');
                personadiv.innerHTML = person.name + "<br>" + person.url;
                perh.appendChild(personadiv);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})

var bDPer = document.getElementById('buscaDescripcionPer');
bDPer.addEventListener("click", function () {
    var id = document.getElementsByClassName('descripcionesPer')[0].value;
    axios.get("https://swapi.dev/api/people/" + id)
        .then(function (response) {
            var idPersona = response.data;
            var desPer = document.getElementById('desper');
            var personadiv = document.createElement('ul');
            desPer.innerHTML = '';
            var perh = document.getElementById('lista');
            perh.innerHTML = '';
            personadiv.innerHTML = "<h3>Name : " + idPersona.name + "</h3>" +
                "<br> gender : " + idPersona.gender +
                "<br> birth year : " + idPersona.birth_year +
                "<br> mass : " + idPersona.mass +
                "<br> height : " + idPersona.height +
                "<br> skin color : " + idPersona.skin_color +
                "<br> hair color : " + idPersona.hair_color +
                "<br> eye color : " + idPersona.eye_color;
            desPer.appendChild(personadiv);

            var fil = document.getElementById('film');
            fil.innerHTML = '';
            idPersona.films.forEach(function (r) {
                var f = document.createElement('li');
                f.innerHTML = "Peliculas: " + r;
                fil.appendChild(f);
            })
            var spe = document.getElementById('specie');
            spe.innerHTML = '';
            idPersona.species.forEach(function (s) {
                var s = document.createElement('li');
                s.innerHTML = "Especies: " + s;
                spe.appendChild(s);
            })
            var sta = document.getElementById('ship');
            sta.innerHTML = '';
            idPersona.starships.forEach(function (s) {
                var sh = document.createElement('li');
                sh.innerHTML = "Naves: " + s;
                sta.appendChild(sh);
            })
            var ve = document.getElementById('vehi');
            ve.innerHTML = '';
            idPersona.vehicles.forEach(function (s) {
                var ve = document.createElement('li');
                ve.innerHTML = "Vehiculos: " + s;
                sta.appendChild(ve);
            })

            document.getElementsByClassName('descripcionesPer')[0].value = "";
        })
        .catch(function (error) {
            var desPer = document.getElementById('desper');
            var errorPersona = document.createElement('h2');
            errorPersona.innerHTML = error.code + " <br>Error de Id";
            desPer.appendChild(errorPersona);
            document.getElementsByClassName('descripcionesPer')[0].value = "";
        });
})

var bClean = document.getElementById('clean');
bClean.addEventListener("click", function () {
    var perh = document.getElementById('lista');
    var desper = document.getElementById('desper');
    var film = document.getElementById('film');
    var specie = document.getElementById('specie')
    var ship = document.getElementById('ship');
    var vehi = document.getElementById('vehi');
    perh.innerHTML = '';
    desper.innerHTML = '';
    film.innerHTML = '';
    specie.innerHTML = '';
    ship.innerHTML = '';
    vehi.innerHTML = '';
})


//planetas
let pla = 0;
var bPlanets = document.getElementById("planets")
bPlanets.addEventListener("click", function () {
    axios.get("https://swapi.dev/api/planets")
        .then(function (response) {
            console.log(response);
            var planetas = response.data.results;
            planetas.forEach(function (p) {
                console.log(p.name);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})


var bFilms = document.getElementById("films")

bFilms.addEventListener("click", function () {
    axios.get("https://swapi.dev/api/films")
        .then(function (response) {
            console.log(response);
            var peliculas = response.data.results;
            peliculas.forEach(function (p) {
                console.log(p.title);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})


var bSpecies = document.getElementById("species")

bSpecies.addEventListener("click", function () {
    axios.get("https://swapi.dev/api/species")
        .then(function (response) {
            console.log(response);
            var especies = response.data.results;
            especies.forEach(function (p) {
                console.log(p.name);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})


var bVehicles = document.getElementById("vehicles")

bVehicles.addEventListener("click", function () {
    axios.get("https://swapi.dev/api/vehicles")
        .then(function (response) {
            console.log(response);
            var vehiculos = response.data.results;
            vehiculos.forEach(function (p) {
                console.log(p.name);
            });
        })
        .catch(function (error) {
            console.log(error);
        });
})


var bStarships = document.getElementById("starships")

bStarships.addEventListener("click", function () {
    axios.get("https://swapi.dev/api/starships")
        .then(function (response) {
            console.log(response);
            var naves = response.data.results;
            naves.forEach(function (p) {
                console.log(p.name);
            })
        })

})