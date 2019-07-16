package com.ipartek.formacion.exception;

import java.util.Scanner;

import com.ipartek.formacion.Youtube;

public class CrearVideoYoutube {

	public static void main(String[] args) throws Exception {
		
				
		
		boolean repetir = true;
		Youtube video = null;

		System.out.println("---- Crear VIDEO YOUTUBE ------------");
		System.out.println("-------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		
		do {
		
			System.out.println("Titulo del Video, recuerda longitud [2,150] :");		
			String titulo = sc.nextLine();
			
			
			System.out.println("Codigo del Video, recuerda longitud [11] :");		
			String codigo = sc.nextLine();
			
			try {
				
				video = new Youtube(titulo, codigo);
				repetir = false;
				
			}catch (Exception e) {
				
				System.out.println("Error " + e.getMessage() );
				System.out.println("Intentalo de nuevo, por favor");
			}
		
		}while( repetir );	
			
		System.out.println("Video Creado correctamente");
		System.out.println(video);
		
		sc.close();

	}

}
