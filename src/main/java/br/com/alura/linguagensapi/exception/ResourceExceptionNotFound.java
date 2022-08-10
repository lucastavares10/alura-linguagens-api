package br.com.alura.linguagensapi.exception;

public class ResourceExceptionNotFound extends RuntimeException {

  public ResourceExceptionNotFound(String id, String resource) {
    super(resource + " não encontrado(a) " + id);
  }

}
