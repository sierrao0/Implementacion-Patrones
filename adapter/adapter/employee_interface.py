from abc import ABC, abstractmethod
from typing import Dict, Any

class EmployeeInterface(ABC):
    @abstractmethod
    def get_employee(self, identifier: Any) -> Dict[str, Any]:
        """
        Abstract method to get employee information
        
        Args:
            identifier: Any type of identifier (could be int or str)
            
        Returns:
            Dict containing employee information
        """
        pass 