<%@page import="beans.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<header> Gestion  des utilisateurs</header>
	<nav>
		<ul>
			<li><a href="<c:url value='/list'/>">Accueil</a></li>
			<li><a href="<c:url value='/list'/>">Lister</a></li>
			<li><a href="<c:url value='/add'/>">Ajouter</a></li>
		</ul>
	</nav>