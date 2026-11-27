Feature: Gestión CRUD de Productos (/api/v1/products)

  Background:
    * url baseUrl
    * header Content-Type = 'application/json'
    * header Accept = 'application/json'

  Scenario: Flujo completo CRUD de un producto
    # 1. CREATE (POST /api/v1/products)
    Given request
      """
      {
        "name": "Aceite Esencial de Lavanda",
        "category": "Aromaterapia",
        "presentation": "Frasco Gotero",
        "measureUnit": "ML",
        "daysUsefulLife": 365,
        "active": true
      }
      """
    When method post
    Then status 201
    And match header Location contains '/api/v1/products/'
    And match response ==
      """
      {
        "id": '#number',
        "internalCode": '#string',
        "name": "Aceite Esencial de Lavanda",
        "category": "Aromaterapia",
        "presentation": "Frasco Gotero",
        "measureUnit": "ML",
        "daysUsefulLife": 365,
        "active": true
      }
      """
    * def createdId = response.id
    * def generatedCode = response.internalCode

    # 2. READ BY ID (GET /api/v1/products/{id})
    Given path createdId
    When method get
    Then status 200
    And match response.id == createdId
    And match response.internalCode == generatedCode
    And match response.name == "Aceite Esencial de Lavanda"

    # 3. READ ALL (GET /api/v1/products)
    When method get
    Then status 200
    And match response == '#[]'
    And match response[*].id contains createdId

    # 4. UPDATE (PUT /api/v1/products/{id}) - Verifica que internalCode no cambia
    Given path createdId
    And request
      """
      {
        "name": "Aceite Esencial de Lavanda Orgánico",
        "category": "Aromaterapia Premium",
        "presentation": "Frasco Ámbar 30ml",
        "measureUnit": "ML",
        "daysUsefulLife": 540,
        "active": false
      }
      """
    When method put
    Then status 200
    And match response ==
      """
      {
        "id": '#(createdId)',
        "internalCode": '#(generatedCode)',
        "name": "Aceite Esencial de Lavanda Orgánico",
        "category": "Aromaterapia Premium",
        "presentation": "Frasco Ámbar 30ml",
        "measureUnit": "ML",
        "daysUsefulLife": 540,
        "active": false
      }
      """

    # 5. DELETE (DELETE /api/v1/products/{id})
    Given path createdId
    When method delete
    Then status 204

    # 6. VERIFY NOT FOUND AFTER DELETE (GET /api/v1/products/{id})
    Given path createdId
    When method get
    Then status 404
    And match response.title == 'Recurso no encontrado'
    And match response.detail contains '#(createdId)'

  Scenario: Rechazar creación con payload inválido (400 Bad Request)
    Given request
      """
      {
        "name": "",
        "daysUsefulLife": -10,
        "active": null
      }
      """
    When method post
    Then status 400
    And match response.title == 'Error de validación'
    And match response.errors.name == '#present'
    And match response.errors.daysUsefulLife == '#present'
    And match response.errors.active == '#present'

  Scenario: Consultar producto inexistente devuelve 404
    Given path 99999999
    When method get
    Then status 404
    And match response.title == 'Recurso no encontrado'
