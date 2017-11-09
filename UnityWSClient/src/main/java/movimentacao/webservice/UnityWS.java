/**
 * UnityWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package movimentacao.webservice;

public interface UnityWS extends java.rmi.Remote {
    public movimentacao.webservice.Negocios[] negociosPreVenda() throws java.rmi.RemoteException;
    public movimentacao.webservice.Atividades ultimaAtividade(movimentacao.webservice.Negocios arg0) throws java.rmi.RemoteException;
    public boolean listaCartaoVisita(java.lang.String arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public movimentacao.webservice.AtividadesDoDia[] ativDoDia() throws java.rmi.RemoteException;
    public boolean cartaoPorId(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public movimentacao.webservice.NomesClientes[] listaClientes() throws java.rmi.RemoteException;
    public java.lang.String novoCliente(java.lang.String arg0) throws java.rmi.RemoteException;
    public movimentacao.webservice.Produto[] listaProduto() throws java.rmi.RemoteException;
    public movimentacao.webservice.ProdutoTask[] listaProdutoTask() throws java.rmi.RemoteException;
}
