#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Order
  I want to use this template for my feature file

@tag1
    Scenario: creat order
  Given customer adress and products
    When creating new order  
    Then Order status should be waiting
    
  @tag2
  Scenario: Add products to order
  Given i have an order
    When Adding products to order
    Then i should get the products 
    
  @tag3
  Scenario: Start treatment order
  Given i have an order
    When Start treatment order
    Then Order status should be in treatmen
