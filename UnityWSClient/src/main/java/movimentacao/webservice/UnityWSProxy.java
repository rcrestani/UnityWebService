package movimentacao.webservice;

public class UnityWSProxy implements movimentacao.webservice.UnityWS {
  private String _endpoint = null;
  private movimentacao.webservice.UnityWS unityWS = null;
  
  public UnityWSProxy() {
    _initUnityWSProxy();
  }
  
  public UnityWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initUnityWSProxy();
  }
  
  private void _initUnityWSProxy() {
    try {
      unityWS = (new movimentacao.webservice.UnityWSServiceLocator()).getUnityWSPort();
      if (unityWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)unityWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)unityWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (unityWS != null)
      ((javax.xml.rpc.Stub)unityWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public movimentacao.webservice.UnityWS getUnityWS() {
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS;
  }
  
  public movimentacao.webservice.Negocios[] negociosPreVenda() throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.negociosPreVenda();
  }
  
  public movimentacao.webservice.Atividades ultimaAtividade(movimentacao.webservice.Negocios arg0) throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.ultimaAtividade(arg0);
  }
  
  public boolean listaCartaoVisita(java.lang.String arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.listaCartaoVisita(arg0, arg1);
  }
  
  public movimentacao.webservice.AtividadesDoDia[] ativDoDia() throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.ativDoDia();
  }
  
  public boolean cartaoPorId(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.cartaoPorId(arg0, arg1);
  }
  
  public movimentacao.webservice.NomesClientes[] listaClientes() throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.listaClientes();
  }
  
  public java.lang.String novoCliente(java.lang.String arg0) throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.novoCliente(arg0);
  }
  
  public movimentacao.webservice.Produto[] listaProduto() throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.listaProduto();
  }
  
  public movimentacao.webservice.ProdutoTask[] listaProdutoTask() throws java.rmi.RemoteException{
    if (unityWS == null)
      _initUnityWSProxy();
    return unityWS.listaProdutoTask();
  }
  
  
}