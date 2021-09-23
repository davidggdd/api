package com.demo.api.repository;

public interface BaseRepository<D, T> {
	// D -> id de la entidad
	// T -> grago que queremos recuperar

    D findWithGraph(T id, String graphName);
}

