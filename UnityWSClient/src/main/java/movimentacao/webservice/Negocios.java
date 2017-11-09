/**
 * Negocios.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package movimentacao.webservice;

public class Negocios  implements java.io.Serializable {
    private movimentacao.webservice.Cliente cliente;

    private java.util.Calendar dataHora;

    private java.lang.Integer id;

    private java.lang.String obs;

    private java.lang.String origem;

    private java.lang.Integer qtdeAtividades;

    private java.lang.String status;

    private movimentacao.webservice.Usuario usuario;

    private float valor;

    public Negocios() {
    }

    public Negocios(
           movimentacao.webservice.Cliente cliente,
           java.util.Calendar dataHora,
           java.lang.Integer id,
           java.lang.String obs,
           java.lang.String origem,
           java.lang.Integer qtdeAtividades,
           java.lang.String status,
           movimentacao.webservice.Usuario usuario,
           float valor) {
           this.cliente = cliente;
           this.dataHora = dataHora;
           this.id = id;
           this.obs = obs;
           this.origem = origem;
           this.qtdeAtividades = qtdeAtividades;
           this.status = status;
           this.usuario = usuario;
           this.valor = valor;
    }


    /**
     * Gets the cliente value for this Negocios.
     * 
     * @return cliente
     */
    public movimentacao.webservice.Cliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this Negocios.
     * 
     * @param cliente
     */
    public void setCliente(movimentacao.webservice.Cliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the dataHora value for this Negocios.
     * 
     * @return dataHora
     */
    public java.util.Calendar getDataHora() {
        return dataHora;
    }


    /**
     * Sets the dataHora value for this Negocios.
     * 
     * @param dataHora
     */
    public void setDataHora(java.util.Calendar dataHora) {
        this.dataHora = dataHora;
    }


    /**
     * Gets the id value for this Negocios.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Negocios.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the obs value for this Negocios.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this Negocios.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the origem value for this Negocios.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this Negocios.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the qtdeAtividades value for this Negocios.
     * 
     * @return qtdeAtividades
     */
    public java.lang.Integer getQtdeAtividades() {
        return qtdeAtividades;
    }


    /**
     * Sets the qtdeAtividades value for this Negocios.
     * 
     * @param qtdeAtividades
     */
    public void setQtdeAtividades(java.lang.Integer qtdeAtividades) {
        this.qtdeAtividades = qtdeAtividades;
    }


    /**
     * Gets the status value for this Negocios.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Negocios.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the usuario value for this Negocios.
     * 
     * @return usuario
     */
    public movimentacao.webservice.Usuario getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this Negocios.
     * 
     * @param usuario
     */
    public void setUsuario(movimentacao.webservice.Usuario usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the valor value for this Negocios.
     * 
     * @return valor
     */
    public float getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this Negocios.
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Negocios)) return false;
        Negocios other = (Negocios) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.dataHora==null && other.getDataHora()==null) || 
             (this.dataHora!=null &&
              this.dataHora.equals(other.getDataHora()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            ((this.qtdeAtividades==null && other.getQtdeAtividades()==null) || 
             (this.qtdeAtividades!=null &&
              this.qtdeAtividades.equals(other.getQtdeAtividades()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            this.valor == other.getValor();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getDataHora() != null) {
            _hashCode += getDataHora().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        if (getQtdeAtividades() != null) {
            _hashCode += getQtdeAtividades().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        _hashCode += new Float(getValor()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Negocios.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "negocios"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "cliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeAtividades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeAtividades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "usuario"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
