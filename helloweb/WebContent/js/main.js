/* 
 *  Nuestro Primer Script
 * 
 */

	


function init(){

	console.debug('DOM cargado y listo para usar');
	//scapeHTML();	
	activateMenu();

}

function scapeHTML(){

	document.querySelectorAll("code").forEach(function(element) {
    	element.innerHTML = element.innerHTML.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#039;");
	});

}


function goTop( event ){
	
	console.debug("pulsado #button-top");
	// prevenir que el ancla navege a otra url
	event.preventDefault();
	
	//buscar body por su id y cambiar scroll = 0 
	document.getElementById("top").scrollTop = 0;
	
	
}

function activateMenu(){

	console.trace('activateMenu inicio');

	var url = window.location.href;
	var anclasMenu = document.querySelectorAll('#menu a');
	console.debug('anclasMenu %o', anclasMenu);

	if ( url.indexOf("/ejemplos-html/") != -1 ){

		console.debug('activate menu html');
		anclasMenu[0].classList.add('active');

	}else if ( url.indexOf("/ejemplos-css/") != -1 ){

		console.debug('activate menu css');
		anclasMenu[1].classList.add('active');

	}else if ( url.indexOf("/ejemplos-js/") != -1 ){

		console.debug('activate menu js');
		anclasMenu[2].classList.add('active');

	}else if ( url.indexOf("/ejemplos-bootstrap/") != -1 ){

		console.debug('activate menu boostrap');
		anclasMenu[3].classList.add('active');

	}else if ( url.indexOf("/ejemplos-servlet/") != -1 ){

		console.debug('activate menu servlet');
		anclasMenu[4].classList.add('active');

	}	

	console.trace('activateMenu fin');

}


 function pruebas(){

	h1 = document.getElementById("titulo1")
	console.debug("seleccionado elemento h1 por su id, contiene texto" + h1.textContent );


	var texto = "hola";

	h1.style.color = 'red';
	h1.textContent = "Nuevo Contenido cambiado por JS";
	h1.innerHTML = h1.innerHTML + `<span class="rojo">
										${texto}
									</span>`;  


	console.info( "Sumar " + ( "1" + 1 ) );
	console.info( "Sumar " + ( 1 + 1 ) );
	console.info( "Sumar " + ( "1" == 1 ) );
	console.info( "Sumar " + ( "1" === 1 ) );


	var parrafos = document.getElementsByTagName("p");
	console.debug("parrafos %o", parrafos);

	for( i=0; i < parrafos.length; i++ ){
		
		parrafos[i].style.color = 'green';
		parrafos[i].style.fontSize = '26px';

	}


	
	var animalesJson = [{
								"nombre": "Gato",
								"clase": "fas fa-cat fa-3x"
							},
							{
								"nombre": "Perro",
								"clase": "fas fa-dog fa-3x"
							},
							{
								"nombre": "Cuervo",
								"clase": "fas fa-crow fa-3x"
							}
						];

	console.debug("animalesJson %o" , animalesJson);	


	var lista = document.getElementById("olAnimales");
	var lis = "";
	
	for( i=0; i < animalesJson.length; i ++){

		lis += `<li>${animalesJson[i].nombre} <i class="${animalesJson[i].clase}"></i></li>`;
	}

	lista.innerHTML = lis;
 }


