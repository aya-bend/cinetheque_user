<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
<h:head>
    <title>Gestion des CDs - Utilisateurs</title>
</h:head>
<h:body>
    <h1>Liste des CDs disponibles</h1>

    <h:form>
        <h:dataTable value="#{userBean.cdDisponibles}" var="cd">
            <h:column>
                <f:facet name="header">Titre</f:facet>
                #{cd.titre}
            </h:column>
            <h:column>
                <f:facet name="header">Actions</f:facet>
                <h:commandButton value="Emprunter" action="#{userBean.emprunterCD}">
                    <f:setPropertyActionListener target="#{userBean.cdId}" value="#{cd.id}" />
                </h:commandButton>
            </h:column>
        </h:dataTable>
    </h:form>

    <h1>Vos emprunts</h1>

    <h:commandButton value="Voir mes emprunts" action="#{userBean.voirEmprunts}" />

    <h:dataTable value="#{userBean.empruntsUtilisateur}" var="emprunt">
        <h:column>
            <f:facet name="header">CD Emprunté</f:facet>
            #{emprunt.cd.titre}
        </h:column>
        <h:column>
            <f:facet name="header">Retour</f:facet>
            <h:commandButton value="Retourner" action="#{userBean.retournerCD(emprunt.id)}" />
        </h:column>
    </h:dataTable>
</h:body>
</html>
