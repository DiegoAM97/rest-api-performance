from fastapi import FastAPI
from routers.user import user_router

app = FastAPI()

app.include_router(user_router)

@app.get("/", tags=["Default"])
async def root():
    return {"message": "Hello World"}