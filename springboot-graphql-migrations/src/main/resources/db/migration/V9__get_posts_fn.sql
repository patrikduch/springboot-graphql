---------------------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Fetch list of posts,
---------------------------------------------------------------------------------------------------------
DO $$ -- IF function already exists we must drop it
BEGIN
	IF EXISTS (
		SELECT format('%I.%I(%s)', ns.nspname, p.proname, oidvectortypes(p.proargtypes)), P.proname
		FROM pg_proc p INNER JOIN pg_namespace ns ON (p.pronamespace = ns.oid)
		WHERE P.proname = 'get_posts_fn') THEN

            DROP FUNCTION springboot_graphql.get_posts_fn;

    END IF;
END;
$$;

DO $_$ -- Function creation
BEGIN
    BEGIN
        CREATE FUNCTION springboot_graphql.get_posts_fn() RETURNS TABLE(
            id UUID,
            title VARCHAR,
            description TEXT
        )  AS $$
        BEGIN
            RETURN QUERY
                SELECT p.id, p."title", p."description" from springboot_graphql.post p;
        END
        $$ LANGUAGE plpgsql;
    END;
END $_$;