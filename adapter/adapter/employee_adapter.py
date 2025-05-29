from typing import Dict, Any, Union
from adapter.employee_interface import EmployeeInterface
from service.database_employee_service import DatabaseEmployeeService
from service.web_service_employee import WebServiceEmployeeService

class EmployeeAdapter(EmployeeInterface):
    def __init__(self):
        self.db_service = DatabaseEmployeeService()
        self.web_service = WebServiceEmployeeService()
    
    def get_employee(self, identifier: Union[str, int]) -> Dict[str, Any]:
        """
        Unified method to get employee information from either source
        
        Args:
            identifier: Can be either an integer (for database) or string (for web service)
            
        Returns:
            Dict containing employee information
        """
        try:
            # If identifier is an integer, use database service
            if isinstance(identifier, int):
                return self.db_service.get_employee_by_id(identifier)
            # If identifier is a string, use web service
            elif isinstance(identifier, str):
                return self.web_service.fetch_employee(identifier)
            else:
                raise ValueError("Identifier must be either string or integer")
        except Exception as e:
            print(f"Error getting employee: {e}")
            raise 