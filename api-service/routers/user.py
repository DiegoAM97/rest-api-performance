from fastapi import APIRouter

user_router = APIRouter(prefix="/users", tags=["Users"])

@user_router.get("/", name="Get all the users", description="Retrieves all the users.")
async def find_all_users():
    return ""


@user_router.get("/{userId}", name="Get user by the userId value", 
                 description="Retrieves the user with ID equals to the parameter.")
async def find_by_user_id(userId: int):
    return userId