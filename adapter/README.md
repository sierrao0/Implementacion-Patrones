# Employee Data Adapter Pattern Implementation

This project demonstrates the Adapter pattern by unifying interfaces for employee data retrieval from both PostgreSQL database and a REST API.

## Setup

1. Install dependencies:
```bash
pip install -r requirements.txt
```

2. Create a `.env` file in the root directory with your PostgreSQL credentials:
```
DB_HOST=your_host
DB_NAME=your_database
DB_USER=your_user
DB_PASSWORD=your_password
```

## Project Structure

- `employee_interface.py`: Base interface definition
- `database_employee_service.py`: PostgreSQL database service implementation
- `web_service_employee.py`: REST API service implementation
- `employee_adapter.py`: Adapter that unifies both interfaces
- `main.py`: Example usage

## Database Setup

You'll need to create a table in your PostgreSQL database:

```sql
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255),
    position VARCHAR(100)
);
```

## Usage

Run the example:
```bash
python main.py
```

The example demonstrates fetching employee data from both the database and the web service using a unified interface.

## Features

- Unified interface for accessing employee data
- PostgreSQL database integration
- REST API integration (using JSONPlaceholder as example)
- Error handling and connection management
- Type hints and documentation 