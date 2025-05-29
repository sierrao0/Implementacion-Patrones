import os
import psycopg2
from typing import Dict, Any
from dotenv import load_dotenv

class DatabaseEmployeeService:
    def __init__(self):
        load_dotenv()
        self.connection = None
        self.connect()
    
    def connect(self):
        """Establishes connection to PostgreSQL database"""
        try:
            self.connection = psycopg2.connect(
                host=os.getenv('DB_HOST'),
                database=os.getenv('DB_NAME'),
                user=os.getenv('DB_USER'),
                password=os.getenv('DB_PASS')
            )
        except psycopg2.Error as e:
            print(f"Error connecting to PostgreSQL: {e}")
            raise

    def get_employee_by_id(self, employee_id: int) -> Dict[str, Any]:
        """
        Retrieves employee information from PostgreSQL by ID
        
        Args:
            employee_id: Integer ID of the employee
            
        Returns:
            Dict containing employee information
        """
        try:
            cursor = self.connection.cursor()
            cursor.execute("""
                SELECT id, first_name, last_name, email, position
                FROM employees
                WHERE id = %s
            """, (employee_id,))
            
            result = cursor.fetchone()
            if result:
                return {
                    'id': result[0],
                    'first_name': result[1],
                    'last_name': result[2],
                    'email': result[3],
                    'position': result[4]
                }
            return None
            
        except psycopg2.Error as e:
            print(f"Error querying database: {e}")
            raise
        finally:
            cursor.close()
    
    def __del__(self):
        """Closes database connection when object is destroyed"""
        if self.connection:
            self.connection.close() 